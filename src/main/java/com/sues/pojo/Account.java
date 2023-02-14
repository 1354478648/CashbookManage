package com.sues.pojo;


//不知道账户是什么意思 需要去问一下 因此暂时只做账户的crud
public class Account {
    String ID;                //账户ID
    String OwnerID;           //账户所有者ID
    String Name;              //账户ID
    String Balance;           //账户余额
    String Type;              //账户类型
    String Status;            //账户状态
    String CreatedAt;         //账户创建时间
    String UpdatedAt;         //账户更新时间

    public Account() {
    }

    public Account(String ID, String ownerID, String name, String balance, String type, String status, String createdAt, String updatedAt) {
        this.ID = ID;
        OwnerID = ownerID;
        Name = name;
        Balance = balance;
        Type = type;
        Status = status;
        CreatedAt = createdAt;
        UpdatedAt = updatedAt;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getOwnerID() {
        return OwnerID;
    }

    public void setOwnerID(String ownerID) {
        OwnerID = ownerID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBalance() {
        return Balance;
    }

    public void setBalance(String balance) {
        Balance = balance;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        CreatedAt = createdAt;
    }

    public String getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        UpdatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Account{" +
                "ID='" + ID + '\'' +
                ", OwnerID='" + OwnerID + '\'' +
                ", Name='" + Name + '\'' +
                ", Balance='" + Balance + '\'' +
                ", Type='" + Type + '\'' +
                ", Status='" + Status + '\'' +
                ", CreatedAt='" + CreatedAt + '\'' +
                ", UpdatedAt='" + UpdatedAt + '\'' +
                '}';
    }
}
