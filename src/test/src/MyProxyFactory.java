import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 17697 on 2016/12/26.
 *
 * 动态代理，代理工厂
 */
public class MyProxyFactory {
    private Object target;
    public MyProxyFactory(Object target) {
        this.target=target;
    }
    public Object getProxyInstance(){
        //返回的代理对象虽然是object类的，但是实质上返回的是target的接口类
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("事务前");
                        method.invoke(target,args);
                        System.out.println("事务后");
                        return null;
                    }
                });
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String strDate="1987-09-09";
        Date date = simpleDateFormat.parse(strDate);
        System.out.println(date);
        System.out.println(date.getTime());
        java.sql.Date dateSql=new java.sql.Date(date.getTime());
        System.out.println(dateSql);
        String string = simpleDateFormat.format(date);
        System.out.println(string);
        Date d=new Date();
        System.out.println(d);
    }
}
