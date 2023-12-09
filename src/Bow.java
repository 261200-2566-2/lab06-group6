public class Bow extends Accessories{
    private double bowDmg = 1.2;

    /** upgrade ค่าเฉพาะของ Bow
     * effects: level ถูกเปลี่ยนค่า (inherited)
     * effects: ค่าการโจมตีของ Bow (bowDmg) และ upgradePrice ถูกเปลี่ยนค่า
     */
    @Override
    public void upgrade() {
        super.upgrade();
        bowDmg *= 1+0.1*getLevel();
        setUpgradePrice(getUpgradePrice()*3);
    }

    /** get ค่าการโจมตีของ Bow
     * @return bowDmg
     */
    public double getBowDmg() {
        return bowDmg;
    }
}
