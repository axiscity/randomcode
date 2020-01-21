
 
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.awt.image.RenderedImage;
import java.awt.image.SampleModel;
import java.awt.image.WritableRaster;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
 
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.lowagie.text.pdf.codec.Base64.InputStream;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
//import org.apache.log4j.Logger;

import java.util.Base64;


public class Main {
 
    private int height;
	private int width;

	//private Logger logger = Logger.getLogger(Main.class);
 
    public Main() {
    }
 
    
    // Load the image get it's size, use the size with the createImageFromBytes function
	public byte[] extractBytes (String ImageName) throws IOException {
		 // open image
		 File imgPath = new File(ImageName);
		 BufferedImage bufferedImage = ImageIO.read(imgPath);

		 this.width = bufferedImage.getWidth();
		 this.height = bufferedImage.getHeight();
		 
		 // get DataBufferBytes from Raster
		 WritableRaster raster = bufferedImage .getRaster();
		 DataBufferByte data   = (DataBufferByte) raster.getDataBuffer();

		 return ( data.getData() );
		 //return bufferedImage;
		}
	
	
	
	// Create an image from the bytes from the blob
	private BufferedImage createImageFromBytes(byte[] imageData) {
	    
		
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(new ByteArrayInputStream(imageData));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//ByteArrayInputStream builtstream = new ByteArrayInputStream(imageData);
		BufferedImage builtimage = new BufferedImage(this.width , this.height, BufferedImage.TYPE_3BYTE_BGR);
		
		// Make raster here
		
		DataBuffer data=new DataBufferByte(imageData, imageData.length);
		SampleModel fmt = builtimage.getSampleModel();
		Raster raster=Raster.createRaster(fmt,data,new Point(0,0));
		
		// Set the bitmap data
		builtimage.setData(raster);
		
		return builtimage;
		
	}
	
	/// not needed
	public static String encodeToString(BufferedImage image, String type) {
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
 
        try {
            ImageIO.write(image, type, bos);
            byte[] imageBytes = bos.toByteArray();
            Base64.Encoder base64Encoder = Base64.getEncoder().withoutPadding();        
            imageString = base64Encoder.encodeToString(imageBytes);
 
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("imageString:" + imageString);
        
        return imageString;
    }
	
	
	
	// Convert to a buffered image
	
	public static BufferedImage convertToBufferedImage(Image image)
	{
	    BufferedImage newImage = new BufferedImage(
	        image.getWidth(null), image.getHeight(null),
	        BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g = newImage.createGraphics();
	    g.drawImage(image, 0, 0, null);
	    g.dispose();
	    return newImage;
	}
	
    
    private void start() {
        try {                                            

        
        	//byte[] imageBytes = extractBytes("D:\\image\\1019.png");
        	
        	//BufferedImage imageFromBytes = createImageFromBytes(imageBytes);
        	
        	//String imageBytes64 = encodeToString(extractBytes("D:\\image\\1019.jpg"), "jpg");
        	//String imageBytes64 = encodeToString(imageFromBytes, "png");
        	
        	//ByteArrayInputStream targetStream = new ByteArrayInputStream(imageBytes);

        	//ImageIcon imageIcon = new ImageIcon(new ImageIcon("D:\\image\\1019.png").getImage());
        	//System.out.println(imageBytes64);

            // load report location
        	
            FileInputStream fis = new FileInputStream("C:\\Users\\Geoff\\JaspersoftWorkspace\\Test\\OneParam.jasper");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fis);
 
            // fill report
            List<Map<String,?>> maps = new ArrayList<Map<String, ?>> (); 
            for (int i = 0; i < 10; i++) {
               
            	Map<String,Object> map = new HashMap<String, Object>();
                //map.put("company_info_logo", imageBytes);
                //map.put("comapny_text", "Whatever");
              

                
                //
            	maps.add(map);
                //maps.add(parametersMap);
            }            

             
            // compile report
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(bufferedInputStream);
 
            Map parametersMap = new HashMap();  
            
            // Create byte image
            byte[] byteImage = extractBytes("D:\\image\\1019.jpg");
            
            // Create buffered image from bytes
            BufferedImage bufferedImage = createImageFromBytes(byteImage);
            

            // For testing
            File outputfile = new File("D:\\image\\output.jpg");
            ImageIO.write(bufferedImage, "jpg", outputfile);
            
            // Send image to jasper report
            parametersMap.put("Cheese", bufferedImage);
            //parametersMap.put("Pickle", "D:\\image\\1019.png");
            
            JRMapCollectionDataSource dataSource = new JRMapCollectionDataSource(maps);
            
            // Fill Jasper report
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametersMap, dataSource);
 
            // view report to UI
            JasperViewer.viewReport(jasperPrint, false);
 
        } catch (Exception e) {
            System.out.println(e + ":" +  e);
        }
    }
     
    private String getRandomString(){
        return UUID.randomUUID().toString();
    }
 
    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }
    
    
    
    
}