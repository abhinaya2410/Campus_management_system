class A extends Thread{
    public void run(){
        for(int i=0;i<50;i++){
            System.out.println("hey hellloo:");
        }
    }  
}

 class B extends Thread{
    public void run(){
        for(int i=0;i<50;i++){
            System.out.println("okayy Byee:");
        }
    }  
}

class try1{
    public static void main(String[]args){
        A threadA = new A();
      //  B threadB = new B();
      for(int i=0;i<50;i++){
        System.out.println("hello world");
      }
      // threadA.setPriority(10);
        threadA.start();
       // threadB.end();
    }
}  

//Race condition
class try4{
    int count = 0;
    public void increment(){
        count++;
    }
}
// solution for Race condition
class try5{
    public static void main(String[] args) throws InterruptedException{
        try4 t = new try4();
        Thread t1 = new Thread(){
            public void run(){
                for(int i = 0; i < 1000; i++){
                    t.increment();
                }
            }
        };
        Thread t2 = new Thread(){
            public void run(){
                for (int i = 0;i<1000;i++){
                    t.increment();
                }
            }
        };
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(t.count);
    }
}