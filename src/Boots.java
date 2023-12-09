public class Boots extends Accessories{
    private double boostSpeed = 1;

    /** upgrade ค่าเฉพาะของ Boots
     * effects: level ถูกเปลี่ยนค่า (inherited)
     * effects: ค่า boostSpeed และ upgradePrice ถูกเปลี่ยนค่า
     */
    @Override
    public void upgrade() {
        super.upgrade();
        boostSpeed *= 1+0.1*getLevel();
        setUpgradePrice(getUpgradePrice()*2);
    }

    /** get ค่า boostSpeed
     * @return boostSpeed
     */
    public double getฺBoostSpeed(){
        return boostSpeed;
    }
}
