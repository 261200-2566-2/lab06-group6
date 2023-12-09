public class Shield extends Accessories{
    private double shieldDef = 1.5;

    /** upgrade ค่าเฉพาะของ Shield
     * effects: level ถูกเปลี่ยนค่า (inherited)
     * effects: ค่าการป้องกันของ Shield (shieldDef) และ upgradePrice ถูกเปลี่ยนค่า
     */
    @Override
    public void upgrade() {
        super.upgrade();
        shieldDef *= 1+0.05*getLevel();
        setUpgradePrice(getUpgradePrice()*3);
    }

    /** get ค่าการป้องกันของ Shield
     * @return shieldDef
     */
    public double getShieldDef(){ return shieldDef; }
}
