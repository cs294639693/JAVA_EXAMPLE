abstract class B {
    private String str;
    
    public B(String a) {
        System.out.println("父类已经实例化");
        this.str=a;
        System.out.println(str);
    }
    
    public abstract void play();
}

/**
 *
 */
public class A extends B{
    /**
     *
     * @param a
     */
    public A(String a) {
        super(a);
        System.out.println("子类已经实例化");
    }

    @Override
    public void play() {
        System.out.println("我实现了父类的方法");
    }
    
    public static void main(String[] args) {
        B aa=new A("a");

    }


    public void aa(){
//        rice r = new rice();
        r.minusQuantity();
    }
    int i;
}