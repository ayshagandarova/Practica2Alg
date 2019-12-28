package nqueen;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ozzy
 */
public class Knight extends JPanel {
    private static int bigDim;
    private static int dim;
    private static int dimension;
    private final static int[][] KnightsMovement = {{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2}};  // knight moves : 8 different ways
    private static int[][] bigTable;
    private static int total;
    private static int t[][];    
    private static int step = 0;
    private static boolean exit = false;
    private static boolean noSol = false;
    public static int size = 35; // size of the cell
    public static int margin = 80;   // margen del frame
    private static boolean started = false;
    static JFrame frame;
    private static int x;
    private static int y;
    public Knight() {
        
        initComponents();
    }
    
    public static void main(String[] args){
        dimension = Integer.parseInt(args[0]); // n x n
        size = Integer.parseInt(args[1]);  // tamaño de cada casilla
        x = Integer.parseInt(args[2]);
        y = Integer.parseInt(args[3]);
        //margin = (args[2].equals("1")) ? size : 0;
        bigDim = dimension + 4;
        dim = dimension * size; // el largo del cuadrado
        
        frame = new JFrame();
        frame.setSize(dim+2*margin, dim+2*margin+size/2); 
        frame.getContentPane().add(new Knight());
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        JButton btnNext = new JButton(); //todo el panel es un botón gigante
        btnNext.setVisible(true);
        frame.add(btnNext);
        btnNext.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
                step++;
                System.out.print("EL contador = " +step + "\n");
                
              }
        });
        start();
    }
    
    private static void start(){
        bigTable = new int[bigDim][bigDim]; 
        total = (dimension) * (dimension);
        t = new int[dimension][dimension];
        for (int r = 0; r < bigDim; r++)
            for (int c = 0; c < bigDim; c++)
                if (r < 2 || r > bigDim - 3 || c < 2 || c > bigDim - 3)
                    bigTable[r][c] = -1;
        
        //definimos las posiciones iniciales x,y
        int row = x + 1; //* dimension ;// 2 + (int) (Math.random() * (dimension));
        int col = y + 1; //* dimension;//(int) (Math.random() * (dimension));
        
        bigTable[row][col] = 1;
 
        if (solve(row, col, 2))
            locateHorse(bigDim);
        else 
            ;
    }
  
    private static boolean solve(int r, int c, int count) { // count = 2,  
        if (count > total)
            return true; // no entra aqui porque esto no es verdad 2 > 64 
 
        List<int[]> nbrs = sides(r, c);
 
        if (nbrs.isEmpty() && count != total)
            return false;
 
        Collections.sort(nbrs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[2] - b[2];
            }
        });
 
        for (int[] nb : nbrs) {
            r = nb[0];
            c = nb[1];
            bigTable[r][c] = count;
            if (!orphanDetected(count, r, c) && solve(r, c, count + 1))
                return true;
            bigTable[r][c] = 0;
        }
 
        return false;
    }
 
    private static List<int[]> sides(int r, int c) {
        List<int[]> nbrs = new ArrayList<>();
 
        for (int[] m : KnightsMovement) { //un for para recorrer todos los posibles movimientos del caballo
            int x = m[0];
            int y = m[1];
            if (bigTable[r + y][c + x] == 0) { //si la casella està buida
                int num = countsides(r + y, c + x); //suma el movimiento del caballo a nuestra row y columna
                nbrs.add(new int[]{r + y, c + x, num});
            }
        }
        return nbrs;
    }
 
    private static int countsides(int r, int c) { //le pasamos ya el movimiento dnde queremos poner el caballo
        int num = 0;
        for (int[] m : KnightsMovement)
            if (bigTable[r + m[1]][c + m[0]] == 0) 
                num++;
        return num;// creemos que cuenta las posibles soluciones dnde colocar caballo
    }
 
    private static boolean orphanDetected(int cnt, int r, int c) {
        if (cnt < total - 1) {
            List<int[]> nbrs = sides(r, c);
            for (int[] nb : nbrs)
                if (countsides(nb[0], nb[1]) == 0)
                    return true;
        }
        return false;
    }
 
    private static void locateHorse(int n) {
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (bigTable[i][j] == -1) continue;
                t[i-2][j-2] = bigTable[i][j];
            }
        }
    }
    
     
    public void paint(Graphics g){
        int d = dimension;
        Image img1 = Toolkit.getDefaultToolkit().getImage("src/knight.png");
        Image img2 = Toolkit.getDefaultToolkit().getImage("src/x.png");
        g.setColor(new Color(255, 189, 35));
        g.fillRect(margin, margin, dim, dim);
        if(d == 1)
             g.drawImage(img1, margin, margin, size, size , null , this);
        else{
            for(int i = margin; i < dim + margin; i+=2*size){
                for(int j = margin; j < dim + margin; j+=2*size){
                    g.clearRect(i, j, size, size);
                }
            }

            for(int i = margin + size; i < dim + margin; i+=2*size){
                for(int j = margin+size; j < dim + margin; j+=2*size){
                    g.clearRect(i, j, size, size);
                }
            }
        }
        
        for(int i = 0; i < d; i++)
            for(int j = 0; j < d; j++)
                if(t[i][j] == 0 && started)
                    g.drawImage(img2, margin + i*size, margin + j * size, size, size , null , this);
        
        for(int i = 0; i < d; i++)
            for(int j = 0; j < d; j++)
                if(step == total+1){
                    step = 0;
                    JOptionPane.showMessageDialog(this, "Finish");
                    frame.dispose();
                }
                else if(t[i][j] == step+1){
                    started = true;
                    g.drawImage(img1, margin + i*size, margin + j * size, size, size , null , this);
                    t[i][j] = 0;
                }    
    }

    
    

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 445, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 416, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
