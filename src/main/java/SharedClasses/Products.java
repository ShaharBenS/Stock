package SharedClasses;


import DAL.Product_Data;

/**
 * Created by Shahar on 29/03/17.
 */
public class Products
{
    private int id;
    private String location;
    private String manufacture;
    private int currentAmount;
    private int amountInWarehouse;
    private int amountInStore;
    private int minimalAmount;
    private int defectAmount;
    private int catergoryCode;

    private int buyPrice;
    private int sellPrice;
    private Date dateStartDiscount;
    private Date dataEndDiscount;
    private int discount;

    public Products(int id, String location, String manufacture, int amountInStore,int amountInStorage, int minimalAmount, int catergoryCode, int buyPrice, int sellPrice)
    {
        this.id = id;
        this.location = location;
        this.manufacture = manufacture;
        this.amountInWarehouse = amountInStorage;
        this.amountInStore = amountInStore;
        this.currentAmount = amountInStorage + amountInStore;
        /**/ defectAmount = 0;
        this.catergoryCode = catergoryCode;
        this.minimalAmount = minimalAmount;

        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        /**/ dateStartDiscount = null;
        /**/ dataEndDiscount = null;
        /**/ discount = 0;
    }

    public boolean equals(Products products)
    {
        return  this.id == products.id &&
                this.location.equals(products.location) &&
                this.manufacture.equals(products.manufacture) &&
                this.currentAmount == products.currentAmount && this.amountInStore == products.amountInStore &&
                this.amountInWarehouse == products.amountInWarehouse && this.minimalAmount == products.minimalAmount &&
                this.defectAmount == products.defectAmount && this.catergoryCode == products.catergoryCode &&
                this.buyPrice == products.buyPrice && this.sellPrice == products.sellPrice &&
                this.dateStartDiscount.equals(products.dateStartDiscount) && this.dataEndDiscount.equals(products.dataEndDiscount)
                && this.discount == products.discount;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public int getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(int currentAmount) {
        this.currentAmount = currentAmount;
    }

    public int getAmountInWarehouse() {
        return amountInWarehouse;
    }

    public void setAmountInWarehouse(int amountIntWarehouse) {
        this.amountInWarehouse = amountIntWarehouse;
    }

    public int getAmountInStore() {
        return amountInStore;
    }

    public void setAmountInStore(int amountInStore) {
        this.amountInStore = amountInStore;
    }

    public int getMinimalAmount() {
        return minimalAmount;
    }

    public void setMinimalAmount(int minimalAmount) {
        this.minimalAmount = minimalAmount;
    }

    public int getDefectAmount() {
        return defectAmount;
    }

    public void setDefectAmount(int defectAmount) {
        this.defectAmount = defectAmount;
    }

    public int getCatergoryCode() {
        return catergoryCode;
    }

    public void setCatergoryCode(int catergoryCode) {
        this.catergoryCode = catergoryCode;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Date getDateStartDiscount() {
        return new Date(dateStartDiscount);
    }

    public void setDateStartDiscount(Date dateStartDiscount)
    {
        this.dateStartDiscount = new Date(dateStartDiscount);
    }

    public Date getDateEndDiscount() {
        return new Date(dataEndDiscount);
    }

    public void setDateEndDiscount(Date dataEndDiscount) {
        this.dataEndDiscount = new Date(dataEndDiscount);
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDateStartDiscount(java.sql.Date date_start)
    {
        this.dateStartDiscount = new Date(date_start);
    }

    public void setDateEndDiscount(java.sql.Date date_end)
    {
        this.dataEndDiscount = new Date(date_end);
    }
}
