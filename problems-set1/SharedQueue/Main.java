import java.util.LinkedList;

public class Main {
    public static void main(String args[]){
        SharedQueue sharedQueue= new SharedQueue(
            new LinkedList<>(), 4
        );


        Thread producerThread= new Thread(
            ()->{
                for(int i=0;i<9;i++){
                    if(i>5) {
                        try {
                            Thread.sleep(5000l);
                        } catch (InterruptedException e) {
                            System.out.println(e.getMessage());
                        }
                    } 
                    sharedQueue.produce();
                }
            }
        );

        Thread consumerThread= new Thread(
            () -> {
                for(int i=0;i<9;i++){
                    if(i<5) {
                        try {
                            Thread.sleep(5000l);
                        } catch (InterruptedException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    
                    sharedQueue.consume();
                }
        });

        producerThread.start();
        consumerThread.start();
    }
}
