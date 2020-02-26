import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.Method;

public class ProxyTest {

    /**
     * 动态代理：
     *  特点：字节码随用随创建，随用随加载
     *  作用：可以在不修改被代理类源码的基础上增强被代理类的方法
     *  分类：
     *      基于接口的动态代理
     *      基于子类的动态代理
     *
     *  基于子类的动态代理：
     *      涉及类：Enhancer,cglib提供
     *
     *  如何创建代理类：调用create方法
     *
     *  被代理类对象的要求：被代理类不能是最终方法
     *
     *   create():
     *      参数：
     *          Class：字节码，用于指定被代理对象的字节码
     *
     *          Callback：用于增强代码
     *
     *
     */

    @Test
    public void test(){

        Producer p = new Producer();

        Producer proxy = (Producer) Enhancer.create(p.getClass(), new MethodInterceptor() {

            /**
             * 执行任何代理对象的方法都会经过该方法
             * @param o：proxy
             * @param method:
             * @param objects:args
             *               以上三个与接口动态代理的相同
             * @param methodProxy：当前执行方法的代理对象
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

                Object obj = null;

                int money = (int) ((int) objects[0] * 0.8);

                obj = method.invoke(p, money);

                return obj;
            }
        });

        proxy.saleProduct(20);

    }

}
