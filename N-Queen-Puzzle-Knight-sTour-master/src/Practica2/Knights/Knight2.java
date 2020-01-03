package Practica2.Knights;

import java.awt.*;
import java.util.List;
import java.util.*;
import javax.swing.*;

public class Knight2 extends JPanel {
    private static int bigDim;
    private static int dim;
    private static int dimension;   
    private final static int[][] KnightsMovement = {{-2,1},{1,-2},{2,1},{1,2},{-1,-2},{-1,2},{-2,-1},{2,-1}}; // knight moves : 8 different ways
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
    private static int[][] path; 
    private int indexStep = 0;
    
    public Knight2() {
        initComponents();
    }
    
    public static void main (String[] args){
        dimension = Integer.parseInt(args[0]); // n x n
        size = Integer.parseInt(args[1]);  // tamaño de cada casilla
        x = Integer.parseInt(args[2]);
        y = Integer.parseInt(args[3]);
        //margin = (args[2].equals("1")) ? size : 0;
        bigDim = dimension + 4;
        dim = dimension * size; // el largo del cuadrado
        
        frame = new JFrame();
        frame.setSize(dim+2*margin, dim+2*margin+size/2); 
        frame.getContentPane().add(new Knight2());
        frame.setLocation(800, 0);
        frame.setBackground(Color.WHITE);
        frame.setTitle("Solución 3");
        frame.setVisible(true);
        
        JButton btnNext = new JButton(); //todo el panel es un botón gigante
        btnNext.setVisible(true);
        frame.add(btnNext);
        btnNext.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
                step++;
              }
        });
        start();
    }
    
    private static void start(){
        bigTable = new int[bigDim][bigDim]; 
        total = (dimension) * (dimension);
        t = new int[dimension][dimension];
        path = new int[dimension][dimension];
        for (int r = 0; r < dimension; r++){
            for (int c = 0; c < dimension; c++){
                path[r][c] = 0;
            }
        }
        for (int r = 0; r < bigDim; r++)
            for (int c = 0; c < bigDim; c++)
                if (r < 2 || r > bigDim - 3 || c < 2 || c > bigDim - 3)
                    bigTable[r][c] = -1;
        
        //definimos las posiciones iniciales x,y
        int row = x + 1; //* dimension ;// 2 + (int) (Math.random() * (dimension));
        int col = y + 1; //* dimension;//(int) (Math.random() * (dimension));
        
        bigTable[row][col] = 1;
 
        if (solve(row, col, 2)) // el segundo movimiento
            locateHorse(bigDim);
        else 
            ;
    }
  
    private static boolean solve(int r, int c, int count) { // count = 2,  
        if (count > total)
            return true; // no entra aqui porque esto no es verdad 2 > 64 
 
        List<int[]> nbrs = sides(r, c);
        //nbrs = array con las filas y columnas, y el numero de las posibles soluciones  
        //si todas las casillas estan ocupadas o fuera del rango entonces nbrs = empty
        if (nbrs.isEmpty() && count != total)  // si hay     2 != 64
            return false;
        
        //Ordena si hay algo en nbrs, de forma que funcione
        //mira si la casilla ya se ha ocupado o no
        Collections.sort(nbrs, new Comparator<int[]>() {  
            public int compare(int[] a, int[] b) {
                int aux = a[2] - b[2];
                return a[2] - b[2];
            }
        });
        
        
        
        //nbrs[0] = {5, 7, 2}
        for (int[] nb : nbrs) { //nb = nbrs[0]
            r = nb[0]; //nb[0] = 5
            c = nb[1]; //nb[1] = 7
            bigTable[r][c] = count; // count = el numero del paso
            //aqui si hay 
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
                nbrs.add(new int[]{r + y, c + x, num}); //añadimos al array lista su nueva posicion 
            // en el array tenemos = fila, columna y las posibles posiciones
            }
        }
        
        //si todas las casillas estan ocupadas o fuera del rango entonces nbrs = empty
        return nbrs;
    }
    //devuelve cuantas opciones hay realmente de las 8
    private static int countsides(int r, int c) { //le pasamos ya el movimiento dnde queremos poner el caballo
        int num = 0;
        for (int[] m : KnightsMovement) //m = el primer movimiento {1, -2}
            if (bigTable[r + m[1]][c + m[0]] == 0){ 
                num++;
            }
        return num;// creemos que cuenta las posibles soluciones dnde colocar caballo 
    }
 
    private static boolean orphanDetected(int cnt, int r, int c) {
        if (cnt < total - 1) {  // 2 < 64-1
            List<int[]> nbrs = sides(r, c);
            for (int[] nb : nbrs) //nb = nbrs[0]
                //entre las diferentes opciones que tenemos
                //elige la primera
                if (countsides(nb[0], nb[1]) == 0)  
                    return true;
        }
        return false;
    }
 
    private static void locateHorse(int n) {
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                //si es un margen = -1 no va a situar el caballo por eso pasa a la 
                //siguiente iteración
                if (bigTable[i][j] == -1) continue;
                t[i-2][j-2] = bigTable[i][j]; //t va a poner las soluciones correctas
                
            }
        }
    }
    
    public void paint(Graphics g){
        int d = dimension; 
        Image img1 = Toolkit.getDefaultToolkit().getImage("src/knight.png");
        g.setColor(new Color(252,224,131));
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
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.BLACK);
        for(int i = 0; i < d; i++){
            for(int j = 0; j < d; j++){
                if(t[i][j] == 0 && started && path[i][j] == 0){
                    path[i][j] = step+1;
                }
                if (path[i][j] != 0 && t[i][j] == 0 && started){
                    g2d.drawString("" + path[i][j], margin + i*size, margin + j * size+ size);
                }
            }
        }
        for(int i = 0; i < d; i++)
            for(int j = 0; j < d; j++)
                if(step == total){
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
