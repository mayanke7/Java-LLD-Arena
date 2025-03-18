import java.util.Queue;

public class SharedQueue {
    private Queue<Integer> queue;
    private Integer bufferSize;

    public SharedQueue(Queue<Integer> queue, Integer bufferSize) {
        this.queue = queue;
        this.bufferSize = bufferSize;
    }

    public Queue<Integer> getQueue() {
        return this.queue;
    }

    public Integer getBufferSize() {
        return this.bufferSize;
    }

    public void setBufferSize(Integer bufferSize) {
        this.bufferSize = bufferSize;
    }

    public void setQueue(Queue<Integer> queue) {
        this.queue = queue;
    }

    public synchronized void consume(){
        System.err.println("consume method is involked");
        while(queue.isEmpty()){
            try {
                System.err.println("consume method has to wait now");
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                System.out.println("consume method wait iis over");
            }
        }
        System.out.println("consume method will poll now and notify");
        queue.poll();
        notifyAll();
    }

    public synchronized  void produce(){
        System.err.println("produce method is involked");

        while(queue.size() >= bufferSize){
            try{
                System.err.println("produce method will wait now");

                wait();
            }catch(InterruptedException e){
                System.err.println(e.getMessage());
                System.err.println("produce method wait iis over");

            }
        }
        System.err.println("produce method will offer now and notify");

        queue.offer(2);
        notifyAll();
    }
    
}
