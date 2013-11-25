import java.util.*;

public class Main {

    public static void main(String[] args) {
        //sout_hw();
        //list_A();
        //reflection();
        //rtti();
        //funD();
        //funE_410();
    }

    private static void funE_410() {
        Map<String, Double> m = E.map();
        m.put("str1", 1.5);
        E.<String, Double>map();
        List<String> l = E.makeList("1", "2");
        System.out.println(l.toString());
    }

    private static void funD() {
        D d = new D();
        d.giveT(17);
        //System.out.println(d.giveT(17));
    }

    private static void rtti() {
        C<A> cint = new C<A>();
        cint.setT(new AA());
        System.out.println(cint.getT());
        cint.setT(new AB());
        System.out.println(cint.getT());
    }

    private static void reflection() {
        new B();
        new B2();
        Class c;// = null;
        try {
            Class.forName("B2");
            //c = Class.forName("BA");
            c = BA.class;
            pr(c);
            for (Class face : c.getInterfaces())
                pr(face);
            Class up = c.getSuperclass();
            pr(up);
        } catch (ClassNotFoundException e) {
            System.out.println("not found");
        }
    }

    static void pr(Class cc) {
        System.out.println("name = " + cc.getName() +
                " interface? [" + cc.isInterface() + "]");
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

class E {
    public static <K, V> Map<K, V> map() {
        return new HashMap<K, V>();
    }

    public static <T> List<T> makeList(T ... args) {
        List<T> lst = new ArrayList<T>();
        for(T item : args)
            lst.add(item);
        return lst;
    }
}

class D {
    //public final int i;
    public <T> void giveT(T t)  // 407 eckel
    {
        System.out.println(t.getClass().getName());
        return;
    }
}

class C<T> {
    private T t;

    T getT() {
        return t;
    }

    void setT(T newT) {
        t = newT;
    }

    String sayMyName() {
        return t.toString();
    }
}

class B {
    static {
        System.out.println("B");
    }
}

class BA extends B implements i1 {
    BA(int i) {
    }
}

class B2 {
    static {
        System.out.println("B2");
    }
}

interface i1 {
}

abstract class A {
    abstract public String toString();
}

class AA extends A {
    public String toString() {
        return "AA";
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