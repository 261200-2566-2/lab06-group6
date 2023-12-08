public class Ring extends Accessories{
    private int boostMana = 1;

    /** upgrade ค่าเฉพาะของ Ring
     * effects: level ถูกเปลี่ยนค่า (inherited)
     * effects: ค่า boostMana และ upgradePrice ถูกเปลี่ยนค่า
     */
    @Override
    public void upgrade() {
        super.upgrade();
        boostMana *= 2;
        setUpgradePrice(getUpgradePrice()*2);
    }

    /** get ค่า boostMana
     * @return boostMana
     */
    public int getBoostMana(){
        return boostMana;
    }
}
