package test;

import api.SpiInterface;
import com.sun.tools.javac.util.ServiceLoader;
import java.util.Iterator;

/**
 * Created by semon on 17/12/26.
 */
public class Test {

    public static void main(String[] args) {
        ServiceLoader<SpiInterface> serviceLoader = ServiceLoader.load(SpiInterface.class);

        Iterator<SpiInterface> it = serviceLoader.iterator();

        while (it != null && it.hasNext()){
            SpiInterface demoService = it.next();

            System.out.println("class:"+demoService.getClass().getName());

            demoService.sayHi();
        }
    }
}
