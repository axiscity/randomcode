package com.packtpub.e4.clock.ui;



import java.awt.Frame;
import java.io.FilenameFilter;

import javax.swing.JFrame;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.swt.widgets.FileDialog;

public class Dia extends TitleAreaDialog {

    private Text txtFirstName;
    private Text lastNameText;

    private String firstName;
    private String lastName;

    private Button sampleButton;
    private Button browseButton;
    
    private Button ok;
    
    public Dia(Shell parentShell) {
        super(parentShell);
    }

    @Override
    public void create() {
        super.create();
        System.out.println("make Dia");
        setTitle("This is my first custom dialog");
        setMessage("This is a TitleAreaDialog", IMessageProvider.INFORMATION);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite area = (Composite) super.createDialogArea(parent);
        Composite container = new Composite(area, SWT.NONE);
        
        
        ///
        
        GridData gridata = new GridData(SWT.FILL, SWT.FILL, true, true);
        gridata.minimumHeight = 600;
        gridata.minimumWidth = 200;
        
        ///
        
        container.setLayoutData(gridata);
        GridLayout layout = new GridLayout(2, false);

        getShell().setText("Whatever");
        
        container.setLayout(layout);

        createFirstName(container);
        createLastName(container);

        return area;
    }
    
    @Override
    protected void configureShell(Shell shell)
    {
        super.configureShell(shell);
        shell.setText("Blah");
    }
    

    private void createFirstName(Composite container) {
        Label lbtFirstName = new Label(container, SWT.NONE);
        lbtFirstName.setText("First Name");

        GridData dataFirstName = new GridData();
        dataFirstName.grabExcessHorizontalSpace = true;
        dataFirstName.horizontalAlignment = GridData.FILL;

        txtFirstName = new Text(container, SWT.BORDER);
        txtFirstName.setLayoutData(dataFirstName);
    }

    private void createLastName(Composite container) {
        Label lbtLastName = new Label(container, SWT.NONE);
        lbtLastName.setText("Last Name");

        GridData dataLastName = new GridData();
        dataLastName.grabExcessHorizontalSpace = true;
        dataLastName.horizontalAlignment = GridData.FILL;
        lastNameText = new Text(container, SWT.BORDER);
        lastNameText.setLayoutData(dataLastName);
    }



    @Override
    protected boolean isResizable() {
        return true;
    }

    // save content of the Text fields because they get disposed
    // as soon as the Dialog closes
    private void saveInput() {
        firstName = txtFirstName.getText();
        lastName = lastNameText.getText();

        //new BrowseFile();
        
    }

    
    @Override
    protected void createButtonsForButtonBar(Composite parent)
    {
      // Change parent layout data to fill the whole bar
      parent.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

  	Display.getDefault().syncExec(new Runnable() {
	    public void run() {
	    	
	    	browseButton = new Button (parent, SWT.PUSH);
	    	browseButton.setText ("Browse This");
	
	        // ...
	        
	    	/// New fix here Best way to do buttons
	    	// Set own id and parent set your own listener see browse button 
	    	
	    	
	    	sampleButton = createButton(parent, 2, "Clear", true);
	        browseButton.addSelectionListener(new Open());
	        // Create a spacer label
	        Label spacer = new Label(parent, SWT.NONE);
	        spacer.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

	        // Update layout of the parent composite to count the spacer
	        GridLayout layout = (GridLayout)parent.getLayout();
	        layout.numColumns++;
	        layout.makeColumnsEqualWidth = false;

	        createButton(parent, 0,"OK", false);
	        createButton(parent, 1,"Cancel", false);
	    	
	    	
	    }
	});
	

	
    }
    
    
    protected void buttonPressed(int buttonId){
    	//System.out.println("button Pressed" + buttonId + IDialogConstants.OK_ID);
    
    	System.out.println(buttonId);
		if (buttonId == 0) {

			ok();
			
		} else if (1 == buttonId) {

			cancel();
			
		} else if (2 == buttonId){
			
			clear();
			
		}
    	
    }
    
    private void clear() {
		// TODO Auto-generated method stub
    	
    	System.out.println("clear");
		
	}

    protected void ok() {
        saveInput();
        System.out.println("OK Pressed");
        super.okPressed();
    }

	protected void cancel() {
		
    	System.out.println("Cancel");
    	super.cancelPressed();
	}

    
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    
	public Shell getShell() {

		  IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

		  if (window == null) {

		    IWorkbenchWindow[] windows = PlatformUI.getWorkbench().getWorkbenchWindows();

		    if (windows.length > 0) {

		       return windows[0].getShell();

		    }

		  }

		  else {

		    return window.getShell();

		  }

		  return null;

		}
    

    	
        //Display d = new Display();
        Shell s = getShell();

        class Open implements SelectionListener {
          public void widgetSelected(SelectionEvent event) {
             
        	System.out.println("Browse This");  
        	FileDialog fd = new FileDialog(s, SWT.OPEN);
            fd.setText("Open");
            fd.setFilterPath("C:/");
            String[] filterExt = { "*.txt", "*.doc", ".rtf", "*.*" };
            fd.setFilterExtensions(filterExt);
            String selected = fd.open();
            System.out.println(selected);
            
            /// null Fix
            
            if(selected!=null){
            txtFirstName.setText(selected);
            } else {
            	
            }
            
          }

          public void widgetDefaultSelected(SelectionEvent event) {
          }
        }

        class Save implements SelectionListener {
          public void widgetSelected(SelectionEvent event) {
            FileDialog fd = new FileDialog(s, SWT.SAVE);
            fd.setText("Save");
            fd.setFilterPath("C:/");
            String[] filterExt = { "*.txt", "*.doc", ".rtf", "*.*" };
            fd.setFilterExtensions(filterExt);
            String selected = fd.open();
            System.out.println(selected);
          }

          public void widgetDefaultSelected(SelectionEvent event) {
          }
        }

}

    
