package com.mycompany.mavenproject1;

import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;


import com.vaadin.server.FileResource;
import com.vaadin.server.Page;
import com.vaadin.server.StreamResource;
import com.vaadin.server.StreamResource.StreamSource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.ProgressBar;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Upload.FailedEvent;
import com.vaadin.ui.Upload.FailedListener;
import com.vaadin.ui.Upload.ProgressListener;
import com.vaadin.ui.Upload.Receiver;
import com.vaadin.ui.Upload.StartedEvent;
import com.vaadin.ui.Upload.StartedListener;
import com.vaadin.ui.Upload.SucceededEvent;
import com.vaadin.ui.Upload.SucceededListener;
import com.vaadin.ui.VerticalLayout;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.annotation.WebServlet;

@Theme("mytheme")
@SuppressWarnings("serial")
@Push
public class MyVaadinUI extends UI
{

   

    
    public static String value;
    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "com.mycompany.mavenproject1.AppWidgetSet")
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);
        if("1".equals(VaadinService.getCurrentRequest().getWrappedSession()
                        .getAttribute("myValue"))){
        advanced(layout);
        }
        final TextField email = new TextField("Email address");
        final TextField password = new TextField("PayMate password");
        Button button = new Button("Login");
        
        Button loginButton = new Button("Log In", new Button.ClickListener() {
        public void buttonClick(ClickEvent event) {
           // saveValue(SettingReadingSessionAttributesUI.this, value);
            authenticate(MyVaadinUI.this,layout,  password.getValue(),email.getValue() );
        }
    });
        
        button.addClickListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                layout.addComponent(new Label("Thank you for clicking"));
            }
        });
         layout.addComponent(new Button("Reload page", new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                getPage().setLocation(getPage().getLocation());
            }
        }));
        //setContent(layout);
       layout.addComponent(email); 
        email.focus();
        layout.addComponent(password); 
       // password.setSecret(true);
         
        layout.setSpacing(true);
        layout.setMargin(true);

        // Keyboard navigation - enter key is a shortcut to login
        
        layout.addComponent(loginButton); 
        
        layout.addComponent(button);  
        
        
    
    }    
    
    
     public void authenticate(MyVaadinUI ui, VerticalLayout layout, String pass , String log) 
    {
        //value 
        if("PASS".equals(pass) && "PASS".equals(log)){
             ui.value = "1";
        // Save to VaadinServiceSession
        ui.getSession().setAttribute("myValue", value);
        // Save to HttpSession
        VaadinService.getCurrentRequest().getWrappedSession().setAttribute("myValue", value);

            Label ok = new Label("Jestes zalogowany "+pass+ " " + log);
            layout.addComponent(ok);
        }
        else
        {
            Label ok = new Label("Złe hasło lub login  "+pass+ " " + log); 
             layout.addComponent(ok);
        }
        
    }

     
     
  /*   private static void showValue(MyVaadinUI ui) {
        ui.layout.removeAllComponents();
        ui.layout.addComponent(new Label("Value in UI: " + ui.value));
        ui.layout.addComponent(new Label(
                "Value in VaadinServiceSession: "
                        + ui.getSession().getAttribute("myValue")));
        ui.layout.addComponent(new Label("Value in HttpSession: "
                + VaadinService.getCurrentRequest().getWrappedSession()
                        .getAttribute("myValue")));
    }*/
     
  

    void advanced(VerticalLayout layout) {
        // BEGIN-EXAMPLE: component.upload.advanced
        class UploadBox extends CustomComponent
              implements Receiver, ProgressListener,
                         FailedListener, SucceededListener {
            private static final long serialVersionUID = -46336015006190050L;

            // Put upload in this memory buffer that grows automatically
            ByteArrayOutputStream os =
                new ByteArrayOutputStream(10240);

            // Name of the uploaded file
            String filename;
            
            ProgressBar progress = new ProgressBar(0.0f);
            
            // Show uploaded file in this placeholder
            Image image = new Image("Uploaded Image");
            
            public UploadBox() {
                // Create the upload component and handle all its events
                Upload upload = new Upload("Upload the image here", null);
                upload.setReceiver(this);
                upload.addProgressListener(this);
                upload.addFailedListener(this);
                upload.addSucceededListener(this);
                
                // Put the upload and image display in a panel
                Panel panel = new Panel("Cool Image Storage");
                panel.setWidth("400px");
                VerticalLayout panelContent = new VerticalLayout();
                panelContent.setSpacing(true);
                panel.setContent(panelContent);
                panelContent.addComponent(upload);
                panelContent.addComponent(progress);
                panelContent.addComponent(image);
                
                progress.setVisible(false);
                image.setVisible(false);
                
                setCompositionRoot(panel);
            }            
            
            public OutputStream receiveUpload(String filename, String mimeType) {
                this.filename = filename;
                os.reset(); // Needed to allow re-uploading
                return os;
            }

            @Override
            public void updateProgress(long readBytes, long contentLength) {
                progress.setVisible(true);
                if (contentLength == -1)
                    progress.setIndeterminate(true);
                else {
                    progress.setIndeterminate(false);
                    progress.setValue(((float)readBytes) /
                                      ((float)contentLength));
                }
            }
               
            
            
            
            public void uploadSucceeded(SucceededEvent event) {
                image.setVisible(true);
                image.setCaption("Uploaded Image " + filename +
                        " has length " + os.toByteArray().length);
                
                // Display the image as a stream resource from
                // the memory buffer
                StreamSource source = new StreamSource() {
                    private static final long serialVersionUID = -4905654404647215809L;

                    public InputStream getStream() {
                        return new ByteArrayInputStream(os.toByteArray());
                    }
                };
                
                if (image.getSource() == null)
                    // Create a new stream resource
                    image.setSource(new StreamResource(source, filename));
                else { // Reuse the old resource
                    StreamResource resource =
                            (StreamResource) image.getSource();
                    resource.setStreamSource(source);
                    resource.setFilename(filename);
                }

                image.markAsDirty();
            }

            @Override
            public void uploadFailed(FailedEvent event) {
                Notification.show("Upload failed",
                                  Notification.Type.ERROR_MESSAGE);
            }
        }
        
        UploadBox uploadbox = new UploadBox();
        layout.addComponent(uploadbox);
        // END-EXAMPLE: component.upload.advanced
    }

}
