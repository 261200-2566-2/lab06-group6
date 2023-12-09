public class Sword extends Accessories{
    private double swordDmg = 1;

    /** upgrade ค่าเฉพาะของ Sword
     * effects: level ถูกเปลี่ยนค่า (inherited)
     * effects: ค่าการโจมตีของ Sword (swordDmg) และ upgradePrice ถูกเปลี่ยนค่า
     */
    @Override
    public void upgrade() {
        super.upgrade();
        swordDmg *= 1+0.2*getLevel();
        setUpgradePrice(getUpgradePrice()*3);
    }
    /** get ค่าการโจมตีของ Sword
     * @return swordDmg
     */
    public double getSwordDmg(){ return swordDmg; }
}
