public class Characters implements Character{
    private String name;
    private String cType;
    private int level = 1;
    private int money = 1000;
    private int hp = 100;
    private int mana = 0;
    private double atk;
    private double def;
    private double speed;
    private Ring ring = new Ring();
    private Boots boots = new Boots();

    /** โชว์ข้อมูลของตัวละคร
     * effects: name, type, level, money, hp, mana, attack, defense และ speed ถูก print
     */
    public void showInfo(){
        System.out.println("--------------------------------------------------------");
        System.out.println("Name: " + name);
        System.out.println("Type: " + cType);
        System.out.println("Level: " + level);
        System.out.println("Money: $ " + money);
        System.out.println("HP: " + hp);
        System.out.println("Mana: " + mana);
        System.out.println("Attack: " + atk);
        System.out.println("Defense: " + def);
        System.out.println("Speed: " + speed);
    }

    /** โจมตีตัวละครฝ่ายตรงข้ามและ update ค่าต่าง ๆ ของตัวละคร
     * @param opp เป็นตัวละครที่ต้องการจุะโจมตี
     * requires: ตัวละครที่ยังไม่ตาย (hp > 0)
     * effects: ค่า mana ของตัวละครจะลดลงทุก ๆ ครั้ง
     * effects: หากโจมตีจนตัวละครฝ่ายตรงข้ามตาย ค่าของ level, money, hp, mana และ speed จะเพิ่มขึ้น
     */
    public void attack(Characters opp){
        if(opp.isDead()) return;
        opp.beAttacked(atk);
        if(mana >= 0) mana -= (int) atk/10;
        if(mana < 0) mana = 0;
        if(opp.isDead()){
            level++;
            money += opp.getMoney()*opp.getLevel();
            hp = 100+5*level;
            if(mana < 100) mana += 10*(level-1);
            speed *= 1.1;
        }
    }

    /** ถูกโจมตี : update ค่า hp ของตัวละครที่ถูกโจมตี
     * @param oppAtk ค่า atk ของตัวละครฝ่ายตรงข้ามที่โจมตีมา
     * effects: ค่า hp ของตัวละครจะลดลงในกรณีที่ def น้อยกว่า oppAtk
     */
    public void beAttacked(double oppAtk){
        double dmg = 0;
        if(oppAtk > def) dmg = oppAtk-def;
        hp -= (int) dmg;
        if(hp <= 0){
            hp = 0;
        }
    }

    /** ใช้/ใส่ accessory (ประกาศให้ว่างไว้ก่อน เพื่อที่จะถูก Overridden ใน class Human และ Elf)
     * @param a ชนิด accessory เป็น uppercase หรือ lowercase ก็ได้
     */
    public void equip(String a){}

    /** ถอด accessory (ประกาศให้ว่างไว้ก่อน เพื่อที่จะถูก Overridden ใน class Human และ Elf)
     * @param a ชนิด accessory เป็น uppercase หรือ lowercase ก็ได้
     */
    public void unEquip(String a){}

    /** upgrade accessory (ประกาศให้ว่างไว้ก่อน เพื่อที่จะถูก Overridden ใน class Human และ Elf)
     * @param a ชนิด accessory เป็น uppercase หรือ lowercase ก็ได้
     */
    public void upgrade(String a){}

    /** เช็คว่าตัวละครตายหรือยัง
     * @return true ถ้า hp น้อยกว่าหรือเท่ากับ 0 นอกเหนือจากนี้ return false
     */
    public boolean isDead(){ return hp <= 0; }

    /** get functions
     * @return ข้อมูล/accessory ตามชื่อ function
     */
    public String getName() { return name; }
    public int getLevel() { return level; }
    public int getMoney() { return money; }
    public int getMana() { return mana; }
    public double getAtk() { return atk; }
    public double getDef() { return def; }
    public double getSpeed() { return speed; }
    public Ring getRing() { return ring; }
    public Boots getBoots(){ return boots; }

    /** set functions
     * requires: ข้อมูลที่ต้องการจะแก้ไข
     * effects: ข้อมูลถูกเปลี่ยนค่าตาม parameter ที่รับมา
     */
    public void setName(String n){ name = n; }
    public void setCType(String s){ cType = s; }
    public void setMoney(int m) { money = m; }
    public void setMana(int m) { mana = m; }
    public void setAtk(double a) { atk = a; }
    public void setDef(double d) { def = d; }
    public void setSpeed(double s) { speed = s; }

}
