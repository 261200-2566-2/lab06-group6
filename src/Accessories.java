public class Accessories implements Accessory{
    private int level = 1;
    private int upgradePrice = 100;

    /** upgrade level ของ accessory
     * effects: level ถูกเปลี่ยนค่า
     */
    public void upgrade() {
        level++;
    }

    /** get ค่า level ของ accessory
     * @return level
     */
    public int getLevel(){
        return level;
    }

    /** get ราคา upgrage ของ accessory
     * @return upgradePrice
     */
    public int getUpgradePrice() {
        return upgradePrice;
    }

    /**
     *
     * @param p upgradePrice ใหม่
     * requires: ค่า upgradePrice ใหม่ที่มากกว่าค่าเดิม
     * effects: upgradePrice ถูกเปลี่ยนค่าตาม parameter ที่รับมา
     */
    public void setUpgradePrice(int p) {
        upgradePrice = p;
    }
}
