package org.jfaster.mango.example.buildin;

import lombok.Data;
import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.ID;
import org.jfaster.mango.crud.CrudDao;
import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.example.util.RandomUtils;
import org.jfaster.mango.operator.Mango;

import javax.sql.DataSource;

public class Strategy2Main {

  public static void main(String[] args) {
    String driverClassName = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/mango_example";
    String username = "root"; // 这里请使用您自己的用户名
    String password = "root"; // 这里请使用您自己的密码
    DataSource ds = new DriverManagerDataSource(driverClassName, url, username, password);
    Mango mango = Mango.newInstance(ds); // 使用数据源初始化mango

    OrderDao orderDao = mango.create(OrderDao.class);

    Order order = new Order();
    String id = RandomUtils.randomStringId(10);
    order.setOrderId(id);
    order.setName("mango");
    order.setPrice(100);
    orderDao.add(order);
    Order orderFromDb = orderDao.getOne(id);

    System.out.println(orderFromDb);
  }

  @DB(table = "order2")
  interface OrderDao extends CrudDao<Order, String> {
  }

  @Data
  public static class Order {

    @ID
    private String orderId;

    private String name;

    private Integer price;

  }

}