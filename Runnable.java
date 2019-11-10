   int i = 0;
   
   Runnable r = new Runnable(){

	   
        private int i = 0;

		public void run() {
        	
        	Thread thisThread = Thread.currentThread();
        	
        	//System.out.println(regen);
        	
        	while (regen) {
        			
        		if(i > 0) {
        			Params.BackupLocation_Field.setText("Whatever" + this.i );
        		}
        		
        		if(i > 9){

        			Stop();
        			
        		}
        		
        		System.out.println(regen);
        		
            	try {
    				Thread.sleep(1000);
    			} catch (InterruptedException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
            	
            	i++;
        		
        	}

            System.out.println("Pickle");
            //MyTimerTask timertask = new MyTimerTask(Params.BackupLocation_Field);
            //timertask.startTask();
       
            Params.BackupLocation_Field.setText("Whatever");
            
        }
    };

    
    new Thread(r).start();
    
    

       
    //r = null;
    
    //Go_btn.setEnabled(false);
    
    
}


protected void Stop() {
	// TODO Auto-generated method stub
	regen = false;
	System.out.println("Thread Stopped");
	
}