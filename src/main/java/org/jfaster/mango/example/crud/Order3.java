package org.jfaster.mango.example.crud;

import com.google.common.base.MoreObjects;
import org.jfaster.mango.annotation.AutoGenerated;
import org.jfaster.mango.annotation.ID;

/**
 * @author ash
 */
public class Order3 {

  @AutoGenerated
  private int id;

  @ID
  private String orderId;

  private int uid;

  private int status;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public int getUid() {
    return uid;
  }

  public void setUid(int uid) {
    this.uid = uid;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("id", id)
        .add("orderId", orderId)
        .add("uid", uid)
        .add("status", status)
        .toString();
  }

}
