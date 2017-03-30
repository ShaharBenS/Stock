package SharedClasses;

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
    private int dataStartDiscount;
    private int dataEndDiscount;
    private int discount;

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

    public int getDataStartDiscount() {
        return dataStartDiscount;
    }

    public void setDataStartDiscount(int dataStartDiscount) {
        this.dataStartDiscount = dataStartDiscount;
    }

    public int getDataEndDiscount() {
        return dataEndDiscount;
    }

    public void setDataEndDiscount(int dataEndDiscount) {
        this.dataEndDiscount = dataEndDiscount;
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
}
