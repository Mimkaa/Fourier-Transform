// importing awt class  
import java.awt.*;
import java.util.ArrayList;  
import java.util.List;

import javax.swing.SwingUtilities;

import java.util.LinkedList;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferStrategy;

import java.util.Comparator;
import java.util.Arrays;
import java.util.Collections;


class ImaginaryNumber
{
    public double re;
    public double im;
    public int frq;
    public double amp;
    public double phase;
    public ImaginaryNumber(double real, double imaginary,int frqq, double ampp, double phasee) {
        this.re = real;
        this.im = imaginary;
        this.amp = ampp;
        this.frq = frqq;
        this.phase = phasee;
    }
}

class Sortbyamp implements Comparator<ImaginaryNumber> {
 
    // Method
    // Sorting in ascending order of roll number
    // Sorting in ascending order of amplitude
    public int compare(ImaginaryNumber a, ImaginaryNumber b)
     {
        return Double.compare(b.amp, a.amp);
    }
}

class Drawer
{
    double x = 200;
    double y =300;
    double radius = 100;
    double fdt = 0;
    
    List<double[]> points;
    Path2D path = new Path2D.Double();
    double[] signalX;
    ImaginaryNumber[] fourierX;
    double[] signalY;
    ImaginaryNumber[] fourierY;
    int signalSize ;
    Drawer()
    {
        signalY = new double[]{44, 44, 44, 44, 46, 46, 46, 46, 48, 48, 48, 48, 50, 50, 52, 52, 52, 52, 52, 52, 50, 50, 48, 48, 46, 46, 44, 44, 44, 42, 42, 40, 40, 40, 40, 40, 40, 40, 42, 42, 42, 44, 44, 46, 46, 48, 48, 50, 50, 52, 54, 54, 54, 56, 56, 56, 56, 56, 56, 56, 56, 56, 58, 58, 58, 58, 60, 60, 60, 60, 62, 62, 62, 62, 60, 60, 60, 58, 58, 56, 56, 54, 54, 54, 52, 52, 52, 52, 52, 52, 52, 52, 52, 50, 50, 50, 48, 48, 48, 48, 50, 50, 52, 52, 54, 56, 56, 58, 60, 62, 62, 64, 66, 68, 68, 70, 72, 74, 76, 78, 78, 80, 82, 84, 84, 86, 88, 90, 92, 94, 94, 94, 96, 96, 98, 100, 100, 102, 104, 104, 106, 108, 110, 110, 112, 114, 114, 116, 118, 120, 122, 122, 124, 126, 128, 130, 132, 134, 136, 136, 138, 140, 142, 142, 142, 142, 144, 144, 144, 144, 144, 146, 146, 146, 146, 148, 150, 150, 150, 150, 148, 148, 148, 148, 148, 148, 148, 148, 148, 148, 150, 152, 154, 156, 158, 160, 162, 162, 164, 166, 166, 166, 166, 168, 168, 168, 170, 170, 170, 172, 172, 170, 170, 170, 170, 170, 170, 170, 170, 172, 174, 174, 176, 176, 178, 180, 180, 182, 182, 184, 184, 186, 186, 188, 188, 188, 190, 192, 192, 194, 194, 196, 196, 196, 194, 194, 192, 192, 192, 192, 190, 190, 188, 188, 188, 188, 188, 190, 192, 194, 194, 194, 196, 196, 196, 196, 196, 198, 198, 198, 198, 200, 200, 200, 200, 202, 202, 202, 202, 204, 204, 204, 204, 206, 206, 206, 206, 206, 206, 206, 208, 208, 208, 208, 208, 208, 208, 208, 208, 208, 208, 208, 210, 210, 210, 210, 212, 212, 212, 212, 212, 212, 212, 212, 212, 212, 212, 212, 212, 210, 210, 210, 210, 210, 210, 210, 210, 210, 210, 208, 208, 208, 208, 208, 206, 206, 206, 204, 204, 204, 204, 204, 202, 202, 200, 200, 198, 198, 198, 196, 196, 196, 194, 194, 192, 192, 190, 190, 188, 188, 186, 186, 184, 182, 180, 180, 182, 182, 182, 184, 184, 184, 186, 186, 186, 184, 182, 182, 180, 180, 178, 176, 174, 172, 172, 170, 168, 166, 164, 164, 164, 164, 164, 164, 164, 164, 164, 164, 164, 162, 160, 160, 160, 158, 158, 158, 158, 156, 156, 156, 152, 150, 148, 146, 144, 142, 140, 140, 140, 140, 140, 142, 142, 142, 142, 142, 142, 142, 142, 142, 140, 138, 138, 138, 138, 138, 136, 136, 136, 136, 134, 134, 134, 132, 132, 132, 132, 130, 128, 126, 124, 124, 122, 120, 120, 118, 116, 114, 112, 110, 108, 106, 106, 104, 102, 102, 100, 98, 96, 94, 92, 90, 88, 86, 84, 82, 80, 78, 76, 72, 70, 68, 66, 64, 62, 60, 58, 56, 54, 52, 52, 50, 48, 48, 46, 44, 44, 44, 44, 44, 44};
       
        
        signalX = new double[]{196, 194, 192, 190, 190, 188, 186, 184, 184, 182, 180, 178, 178, 176, 176, 174, 172, 170, 168, 166, 166, 164, 164, 162, 162, 160, 160, 158, 156, 156, 154, 154, 152, 150, 148, 146, 144, 142, 142, 140, 138, 136, 134, 134, 132, 132, 130, 130, 128, 128, 128, 126, 124, 124, 120, 118, 116, 114, 112, 110, 108, 106, 106, 104, 102, 100, 98, 96, 94, 92, 92, 90, 88, 86, 86, 84, 82, 82, 80, 78, 76, 76, 74, 72, 72, 70, 68, 66, 64, 62, 60, 58, 56, 56, 54, 52, 52, 50, 48, 46, 44, 42, 42, 40, 40, 40, 38, 38, 38, 38, 36, 36, 36, 36, 34, 34, 34, 34, 34, 34, 36, 36, 36, 36, 38, 38, 38, 40, 40, 40, 42, 44, 42, 40, 40, 40, 38, 38, 38, 36, 36, 36, 36, 34, 34, 34, 32, 32, 32, 32, 32, 30, 30, 30, 30, 30, 30, 30, 30, 28, 28, 28, 28, 26, 24, 22, 22, 20, 18, 16, 14, 12, 10, 8, 6, 4, 6, 8, 10, 12, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 30, 30, 30, 30, 30, 30, 30, 32, 32, 32, 30, 28, 26, 24, 22, 20, 20, 18, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 38, 40, 40, 42, 42, 42, 40, 40, 38, 38, 36, 36, 34, 34, 32, 30, 30, 30, 28, 28, 26, 26, 28, 30, 30, 32, 32, 34, 36, 38, 38, 40, 40, 42, 44, 46, 48, 48, 50, 50, 52, 54, 56, 58, 60, 62, 64, 64, 66, 68, 70, 70, 68, 66, 64, 70, 72, 74, 76, 76, 78, 80, 82, 84, 86, 88, 90, 92, 94, 96, 96, 98, 100, 102, 104, 106, 108, 110, 112, 114, 116, 118, 120, 122, 124, 126, 126, 128, 130, 132, 134, 136, 138, 140, 142, 144, 146, 148, 150, 150, 152, 154, 156, 158, 160, 162, 164, 166, 168, 168, 170, 172, 174, 176, 176, 178, 180, 180, 182, 184, 186, 188, 188, 190, 190, 192, 192, 194, 196, 196, 198, 200, 200, 202, 202, 204, 204, 206, 206, 208, 208, 210, 210, 212, 212, 214, 214, 216, 218, 218, 220, 222, 222, 224, 226, 226, 226, 224, 222, 220, 220, 218, 218, 218, 220, 220, 220, 220, 220, 222, 224, 226, 228, 230, 232, 234, 236, 238, 240, 240, 240, 238, 236, 236, 234, 232, 230, 230, 228, 226, 224, 224, 224, 224, 224, 224, 224, 226, 228, 230, 232, 232, 234, 236, 238, 240, 242, 244, 246, 248, 248, 248, 246, 244, 242, 240, 240, 238, 236, 234, 234, 232, 230, 230, 228, 226, 224, 224, 224, 224, 224, 222, 222, 222, 220, 220, 220, 220, 220, 220, 218, 218, 220, 220, 220, 222, 222, 222, 222, 222, 222, 222, 222, 222, 222, 220, 218, 216, 214, 214, 214, 214, 214, 214, 214, 214, 214, 212, 212, 212, 210, 210, 210, 208, 208, 208, 206, 204, 202, 200, 198};
      
        signalSize = signalY.length;
        points = new ArrayList();
        fourierY = DiscreteFourierTransform(signalY);
        fourierX = DiscreteFourierTransform(signalX);
        Sortbyamp comp = new Sortbyamp();
        Arrays.sort(fourierX,comp);
        Arrays.sort(fourierY,comp);
    }
    
    synchronized void update(double dt)
    {
        // clear the points
        if(points.size()>1500)
        {
            points.remove(points.size()-1);
        }
        
        
    }

    double[] DrawEpicycles(Graphics2D g2d, double x, double y, ImaginaryNumber[] fourier, double dt, double rotation)
    {
        double pointX = x;
        double pointY = y;
       
        for (int i = 0; i < fourier.length; i++)
        {
            
            // draw a circle on the runnung dot on another circle
            double lastCX = pointX;
            double lastCY = pointY;

            int frq = fourier[i].frq;
            double phase = fourier[i].phase;
            double amp = fourier[i].amp;
            int n = frq;
            double calcRad = amp;

            g2d.setColor(Color.RED);
            g2d.drawOval((int)(pointX - calcRad), (int)(pointY - calcRad), (int)(calcRad*2), (int)(calcRad*2));

            // draw the running dot on the new circle
            pointX = lastCX + calcRad * Math.cos(n*dt+phase+rotation);
            pointY= lastCY + calcRad * Math.sin(n*dt+phase+rotation);
            
            
            
           
            g2d.setColor(Color.BLUE);
            g2d.drawLine((int)lastCX, (int)lastCY, (int)pointX, (int)pointY);
           
            
            
        }
        
        // draw a point
        
        return new double[]{pointX, pointY};
    }

    ImaginaryNumber[] DiscreteFourierTransform(double[] signalIn)
    {
        ImaginaryNumber[] X = new ImaginaryNumber[signalIn.length];

        for(int k = 0; k < signalIn.length; k++)
        {
            double re = 0;
            double im = 0;
            for(int n = 0; n < signalIn.length; n++)
            {
                double angle = ((Math.PI*2)*k*n)/signalIn.length;
                re+=signalIn[n] * Math.cos(angle);
                im-=signalIn[n] * Math.sin(angle);
            }
             
            re/=signalIn.length;
            im/=signalIn.length;

            int frq = k;
            double amp = Math.sqrt((re*re)+(im*im));
            double phase = Math.atan2(im,re);

            ImaginaryNumber imaginaryNumber = new ImaginaryNumber(re,im,frq,amp,phase);
            X[k] = imaginaryNumber;
        }

        return X;
    }

   

    synchronized void draw(Graphics g, double dt)
    {
        
        Graphics2D g2d = (Graphics2D)g;

        fdt += Math.PI*2/fourierY.length;
        double[] vx = DrawEpicycles(g2d, 300, 100, fourierX, fdt,0);
        double[] vy = DrawEpicycles(g2d, 100, 300, fourierY, fdt, Math.PI/2);
        // one is drawing x part another is drawing y part
        double[] v = new double[]{vx[0],vy[1]};
        points.add(new double[]{v[0], v[1]});
       // draw function line
        path.reset(); // Reset the path
        path.moveTo(points.get(0)[0], points.get(0)[1]);
        for (int i = 1; i < points.size(); ++i) {
            path.lineTo(points.get(i)[0], points.get(i)[1]);
            
        }
        g2d.setColor(Color.BLUE);
        g2d.draw(path);

        // draw the line from the going point to the beginning of the path
        g2d.drawLine((int)vx[0], (int)vx[1], (int)v[0], (int)v[1]);
        g2d.drawLine((int)vy[0], (int)vy[1], (int)v[0], (int)v[1]);
        
    }
}

// class which inherits the Canvas class  
// to create Canvas  
class MyCanvas extends Canvas    
{    
    public Drawer drawer;
    private BufferedImage offscreenImage;
   
    private boolean drawingComplete = false;
    
  

    // class constructor  
     public MyCanvas() 
    {    
        super();
        setBackground (Color.BLACK);    
        setSize(800, 600);
        drawer = new Drawer();    
        offscreenImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        
        
    } 

    public static boolean isFilledWithColor(BufferedImage image, Color color) {
        int width = image.getWidth();
        int height = image.getHeight();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (image.getRGB(x, y) != color.getRGB()) {
                    return false; // Found a pixel with a different color
                }
            }
        }

        return true; // All pixels have the specified color
    }
    
    public void updateDrawer(double dt)
    {
        drawer.update(dt);
        
    }
  
     // paint() method to draw inside the canvas  
    public void render(double dt) {
        BufferStrategy bufferStrategy = getBufferStrategy();

        if (bufferStrategy == null) {
            createBufferStrategy(2);
            return;
        }

        Graphics g = bufferStrategy.getDrawGraphics();
        g.fillRect(0, 0, 800, 600);
        drawer.draw(g,dt);

        g.dispose();
        bufferStrategy.show();
    }
}       
  
// class to construct a frame and containing main method    
public class FourierTransform  
{
    public Frame frame;
    public MyCanvas canvas;
    public double timeStep = 0.01;
  // class constructor   
    public FourierTransform()    
    {    
        canvas = new MyCanvas();
        // creating a frame  
        this.frame = new Frame("Canvas Example");   
        // adding canvas to frame   
        this.frame.add(canvas);    
    
        // setting layout, size and visibility of frame  
        this.frame.setLayout(null);    
        this.frame.setSize(800, 600);    
        this.frame.setVisible(true);    

       

        // Create a separate thread for continuous updates
        Thread updateThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    canvas.updateDrawer(timeStep);
                    canvas.render(timeStep);
                    try {
                        Thread.sleep(10); // Adjust the sleep time as needed
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    
                    timeStep+=(Math.PI*2)/canvas.drawer.signalSize;
                }
            }
        });

        updateThread.start(); // Start the thread

       

        
    }    
  
  // main method  
    public static void main(String args[])    
    {    
        FourierTransform wind = new FourierTransform();    
       
       
    }    
}    
  
