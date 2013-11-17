import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //sout_hw();
        //list_A();
        new B();
        new B2();
        Class c;// = null;
        try {
            Class.forName("B2");
            //c = Class.forName("BA");
            c = BA.class;
            pr(c);
            for(Class face : c.getInterfaces())
                pr(face);
            Class up = c.getSuperclass();
            pr(up);
        } catch (ClassNotFoundException e) {
            System.out.println("not found");
        }
    }
    static void pr(Class cc)
    {
        System.out.println("name = " + cc.getName() +
                " interface? [" + cc.isInterface() + "]" );
        System.out.println("sname = " + cc.getSimpleName());
        System.out.println("cano name = " + cc.getCanonicalName());

    }

    private static void list_A() {
        List<A> alist = Arrays.asList(new AA(), new AB(), new AC());
        for (A item : alist)
            System.out.println(item);
    }

    private static void sout_hw() {
        System.out.println("hw");
        System.out.println("hw2");
        System.out.println("3");
        System.out.println("4");
    }
}

class B {
    static {
        System.out.println("B");
    }
}
class BA extends B implements  i1
{
    BA(int i) {}
}

class B2 {
    static {
        System.out.println("B2");
    }
}

interface  i1{}

abstract class A {
    abstract public String toString();
}

class AA extends A {
    public String toString() {
        return "AB";
    }
}

class AB extends A {
    public String toString() {
        return "AB";
    }
}

class AC extends A {
    public String toString() {
        return "AC";
    }
}