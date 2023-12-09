public class Headband extends Accessories{
    private double hbDef = 1.2;

    /** upgrade ค่าเฉพาะของ Headband
     * effects: level ถูกเปลี่ยนค่า (inherited)
     * effects: ค่าการป้องกันของ Headband (hbDef) และ upgradePrice ถูกเปลี่ยนค่า
     */
    public void upgrade() {
        super.upgrade();
        hbDef *= 1+0.1*getLevel();
        setUpgradePrice(getUpgradePrice()*3);
    }

    /** get ค่าการป้องกันของ Headband
     * @return hbDef
     */
    public double getHbDef() {
        return hbDef;
    }
}
