package com.mycompany.mavenproject1;
import com.google.gwt.json.client.JSONObject;
import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.data.validator.RegexpValidator;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.StreamResource;
import com.vaadin.server.StreamResource.StreamSource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.AbstractTextField;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.ProgressBar;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Upload.FailedEvent;
import com.vaadin.ui.Upload.FailedListener;
import com.vaadin.ui.Upload.ProgressListener;
import com.vaadin.ui.Upload.Receiver;
import com.vaadin.ui.Upload.SucceededEvent;
import com.vaadin.ui.Upload.SucceededListener;
import com.vaadin.ui.VerticalLayout;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Theme("mytheme")
@SuppressWarnings("serial")
@Push
public class MyVaadinUI extends UI
{

    public ArrayList<Person>  dbb = new ArrayList<Person>();
    private Table table = new Table("Lista Filmów");
    final TextField nazwap = new TextField("Nazwa");
    final TextField urlp = new TextField("Url zdjecia");
    int id=0;
    private HorizontalLayout hl = new HorizontalLayout();
   final TextField searchName = new TextField("Szukaj nazwe");
    public static String value = "0";
    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "com.mycompany.mavenproject1.AppWidgetSet")
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
        
        
        final VerticalLayout layout = new VerticalLayout();
        final VerticalLayout login = new VerticalLayout();
         final VerticalLayout addper = new VerticalLayout();
         
        
        setContent(hl);
       
        hl.addComponent(layout);
        hl.addComponent(addper);
        hl.addComponent(login);
       
        //Jeżeli jesteś zalogowany !!!
        if("1".equals(VaadinService.getCurrentRequest().getWrappedSession()
                        .getAttribute("myValue")))
        {
            //advanced(layout);
           final Button logoutt = new Button("Wyloguj", new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                logout(MyVaadinUI.this);
                //FORM(layout);
                }
            });
            login.addComponent(new Button("Upload", new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                login.removeAllComponents();
                advanced(login);
                login.addComponent(logoutt);
               
            }
        }));
            //logoutt.addStyleName("Siemka"); 
            login.addComponent(logoutt); 
        layout.setSpacing(true);
        layout.setMargin(true);
        login.setSpacing(true);
        }
        //Jeżeli nie jesteś zalogowany 
        else{
            final TextField email = new TextField("Email");
            final PasswordField password = new PasswordField("Hasło");
            
           
            login.addComponent(email); 
            email.focus();
            login.addComponent(password); 
            final Button loginButton = new Button("Log In", new Button.ClickListener() {
                public void buttonClick(ClickEvent event) {
                 // saveValue(SettingReadingSessionAttributesUI.this, value);
                authenticate(MyVaadinUI.this,layout,  password.getValue(),email.getValue() );
                }
            });
            login.addComponent(loginButton); 
            Property.ValueChangeListener checkForm = new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                if(email.isValid() && password.isValid()) {
                    loginButton.setEnabled(true);
                } else {
                    loginButton.setEnabled(false);
                }
            }
        };
        //walidacja emaila
        email.addValidator(new EmailValidator("Błędy adres e-mail"));
        email.addValidator(new StringLengthValidator("Pole wymagane", 1, Integer.MIN_VALUE, false));

        // walidacja hasło
        password.addValidator(new StringLengthValidator("Hasło minimum 6 znaków", 6, Integer.MIN_VALUE, false));

        email.addValueChangeListener(checkForm);
        password.addValueChangeListener(checkForm);
        email.setTextChangeEventMode(AbstractTextField.TextChangeEventMode.EAGER);
        password.setTextChangeEventMode(AbstractTextField.TextChangeEventMode.EAGER);
        email.setImmediate(true);
        password.setImmediate(true);
        nazwap.addValidator(new StringLengthValidator("minimum 6 znaków", 6, Integer.MIN_VALUE, false));
        urlp.addValidator(new StringLengthValidator("minimum 6 znaków", 6, Integer.MIN_VALUE, false));

        }
        
        
        
        addper.addComponent(new Button("Dodaj film", new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                //addPerson();
                Person   newPerson = new Person(id++,nazwap.getValue(),urlp.getValue(),"elo","11-500");
                dbb.add(newPerson);
                showPerson(layout);
               
            }
        }));
         
       
         layout.addComponent(new Button("Szukaj Film", new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
               // addPerson();
               showPerson(layout);
               
            }
        }));
         
         
         
          
         
        Property.ValueChangeListener szukaj = new Property.ValueChangeListener() {
            
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
             showPerson(layout);   
            } 
          };
        searchName.addValueChangeListener(szukaj);
        searchName.setTextChangeEventMode(AbstractTextField.TextChangeEventMode.EAGER);
        searchName.setImmediate(true);
        layout.setWidth("70%");
        login.setWidth("10%");
        hl.setWidth("100%");
        addper.setWidth("20%");
        layout.addComponent(searchName);
        showPerson(layout);
        layout.setSpacing(true);
        layout.setMargin(true);
        login.setSpacing(true);
        addper.addComponent(nazwap);
        addper.addComponent(urlp);
        addper.setSpacing(true);
        addper.setMargin(true);
    }    
    //// koniec init
    
    public void showPerson(VerticalLayout layout){
        {
            String szuk = searchName.getValue();
            int ile = szuk.length();
           table.removeAllItems();
            layout.removeComponent(table);
		table.addContainerProperty("name", String.class, null);
		table.addContainerProperty("url", Link.class, null);
                //table.addContainerProperty("ileeeee", String.class, null);
		//table.addContainerProperty("action", Button.class, null);
		for (final Person p : dbb){
                    if(ile==0){
			Item item = table.addItem(p.getId());
			item.getItemProperty("name").setValue(p.getName());
                       // item.getItemProperty("ileeeee").setValue(ile+" : "+ szuk);
			Link lk = new Link("", new ExternalResource(p.getLink()));
			lk.setIcon(new ExternalResource(p.getLink()));
			item.getItemProperty("url").setValue(lk);
                    }
                    else
                    {
                        String foo = p.getName().substring(0, Math.min(ile, p.getName().length()));
                        if(foo.equals(szuk))
                        {
                        Item item = table.addItem(p.getId());
			item.getItemProperty("name").setValue(p.getName());
			Link lk = new Link("", new ExternalResource(p.getLink()));
			lk.setIcon(new ExternalResource(p.getLink()));
			item.getItemProperty("url").setValue(lk);
                        }
                    }
		}

		layout.addComponent(table);
		
	}
        
    }
    public void addPerson(){
        Person   newPerson = new Person(id++,"lol","www.jacie.pl","elo","11-500");
	dbb.add(newPerson);
	//Person_list.broadcast(newPerson);
    }
    
      public void logout(MyVaadinUI ui) {
          ui.value = "0";
        // Save to VaadinServiceSession
        ui.getSession().setAttribute("myValue", value);
        // Save to HttpSession
        VaadinService.getCurrentRequest().getWrappedSession().setAttribute("myValue", value);
        getPage().setLocation(getPage().getLocation());
          
      }
      public void authenticate(MyVaadinUI ui, VerticalLayout layout, String pass , String log) 
    {
        //value 
        if("pass@wp.pl".equals(log) && "pass123".equals(pass)){
             ui.value = "1";
        // Save to VaadinServiceSession
        ui.getSession().setAttribute("myValue", value);
        // Save to HttpSession
        VaadinService.getCurrentRequest().getWrappedSession().setAttribute("myValue", value);
        getPage().setLocation(getPage().getLocation());
            Label ok = new Label("Jestes zalogowany "+pass+ " " + log);
            layout.addComponent(ok);
        }
        else if("PASS1".equals(pass) && "PASS1".equals(log)){
                  ui.value = "2";
        // Save to VaadinServiceSession
        ui.getSession().setAttribute("myValue", value);
        // Save to HttpSession
        VaadinService.getCurrentRequest().getWrappedSession().setAttribute("myValue", value);
       getPage().setLocation(getPage().getLocation());
        Label ok = new Label("Jestes zalogowany do form  "+pass+ " " + log );
            layout.addComponent(ok);
        }
        
        else 
        {
            ui.value = "0";
        // Save to VaadinServiceSession
        ui.getSession().setAttribute("myValue", value);
        // Save to HttpSession
        VaadinService.getCurrentRequest().getWrappedSession().setAttribute("myValue", value);
       getPage().setLocation(getPage().getLocation());
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
