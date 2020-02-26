import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    /**
     * 动态代理：
     *  特点：字节码随用随创建，随用随加载
     *  作用：可以在不修改被代理类源码的基础上增强被代理类的方法
     *  分类：
     *      基于接口的动态代理
     *      基于子类的动态代理
     *
     *  基于接口的动态代理：
     *      涉及类：Proxy,JDK官方提供
     *
     *  如何创建代理类：调用Proxy.newInstance()
     *
     *  被代理类对象的要求：必须实现至少一个接口
     *
     *   newInstance():
     *      参数：
     *          ClassLoder loder：类加载器
     *              它是用于加载代理对象的字节码，和被代理对象的类加载器相同
     *          Class[] interfaces: 接口的字节码数组
     *          InvocationHandler h：
     *              是一个接口实现对象，它invoke方法用于增强被代理类方法
     *              代理类的每一个方法都会调用它
     *
     *
     */

    @Test
    public void test(){

        Producer p = new Producer();

        IProducer proxy = (IProducer)Proxy.newProxyInstance(p.getClass().getClassLoader(),
                new Class[]{IProducer.class},
                new InvocationHandler() {

                    /**
                     *
                     * @param proxy: 代理对象
                     * @param method：代理对象调用的方法对象
                     * @param args：代理方法参数
                     * @return 代理方法的返回值
                     * @throws Throwable
                     */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                Object obj = null;

                int money = (int)((int)args[0] * 0.8);

                obj = method.invoke(p,money);

                return obj;

            }
        });

        proxy.saleProduct(20);

    }

}
