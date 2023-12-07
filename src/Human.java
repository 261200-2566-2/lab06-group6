public class Human extends Characters{
    private Sword sword = new Sword();
    private Shield shield = new Shield();
    private boolean[] humanAcc = new boolean[4];
    boolean isStrengthAct;
    public Human(String n){
        setName(n);
        setCType("Human");
        setAtk(10);
        setDef(5);
        setSpeed(10);
    }

    /** โชว์ข้อมูลของตัวละคร โดยมีข้อมูล Equipped Items(Accessories) เพิ่มเข้ามาจากที่ประกาศไว้ใน class Characters
     * effects: name, type, level, money, hp, mana, attack, defense และ speed ถูก print (inherited)
     * effects: สถานะของ Sword, Shield, Ring และ Boots ถูก print
     */
    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Equipped Items:");
        System.out.print("   Sword: ");
        if(humanAcc[0]) System.out.println("Level " + sword.getLevel());
        else System.out.println("-");
        System.out.print("   Shield: ");
        if (humanAcc[1]) System.out.println("Level " + shield.getLevel());
        else System.out.println("-");
        System.out.print("   Ring: ");
        if (humanAcc[2]) System.out.println("Level " + getRing().getLevel());
        else System.out.println("-");
        System.out.print("   Boots: ");
        if (humanAcc[3]) System.out.println("Level " + getBoots().getLevel());
        else System.out.println("-");
        System.out.println("--------------------------------------------------------");
    }

    /** ใช้/ใส่ accessory (ใส่ได้ทีละอย่าง)
     * @param a ชนิด accessory ได้แก่ Sword, Shield, Ring และ Boots เป็น uppercase หรือ lowercase ก็ได้
     * effects: หากป้อนชนิด accessory ถูกต้องและ accessory นั้นไม่ได้ถูกใส่อยู่
     *          - humanAcc[...] จะเปลี่ยนเป็น true
     *          - ตัวละครจะเพิ่มขึ้นตาม accessory ที่เลือกใส่
     * effects: ข้อความที่บอกว่าการเลือกใส่ accessory สำเร็จหรือไม่ ถูก print
     */
    @Override
    public void equip(String a) {
        switch(a.toLowerCase()){
            case "sword":
                if(!humanAcc[0]){
                    humanAcc[0] = true;
                    setAtk(getAtk()+sword.getSwordDmg());
                    System.out.println(getName() + " has equipped the sword.");
                }else System.out.println(getName() + " already has a sword equipped.");
                break;
            case "shield":
                if(!humanAcc[1]){
                    humanAcc[1] = true;
                    setDef(getDef()+shield.getShieldDef());
                    System.out.println(getName() + " has equipped the shield.");
                }else System.out.println(getName() + " already has a shield equipped.");
                break;
            case "ring":
                if(!humanAcc[2]){
                    humanAcc[2] = true;
                    setMana(getMana()+getRing().getBoostMana());
                    System.out.println(getName() + " has equipped the ring.");
                }else System.out.println(getName() + " already has a ring equipped.");
                break;
            case "boots":
                if(!humanAcc[3]){
                    humanAcc[3] = true;
                    setSpeed(getSpeed()+getBoots().getฺBoostSpeed());
                    System.out.println(getName() + " has equipped the boots.");
                }else System.out.println(getName() + " already has boots equipped.");
                break;
            default:
                System.out.println("Wrong input!");
        }
    }
    /** ถอด accessory (ถอดได้ทีละอย่าง)
     * @param a ชนิด accessory ได้แก่ Sword, Shield, Ring และ Boots เป็น uppercase หรือ lowercase ก็ได้
     * effects: หากป้อนชนิด accessory ถูกต้องและ accessory นั้นถูกใส่อยู่
     *          - humanAcc[...] จะเปลี่ยนเป็น false
     *          - stat ตัวละครจะลดลงตาม accessory ที่ถอดออกไป
     * effects: ข้อความที่บอกว่าการเลือกถอด accessory สำเร็จหรือไม่ ถูก print
     */
    @Override
    public void unEquip(String a) {
        switch(a.toLowerCase()){
            case "sword":
                if(humanAcc[0]){
                    humanAcc[0] = false;
                    setAtk(getAtk()-sword.getSwordDmg());
                    System.out.println(getName() + " has unequipped the sword.");
                }else System.out.println(getName() + " doesn't have a sword equipped.");
                break;
            case "shield":
                if(humanAcc[1]){
                    humanAcc[1] = false;
                    setDef(getDef()-shield.getShieldDef());
                    System.out.println(getName() + " has unequipped the shield.");
                }else System.out.println(getName() + " doesn't have a shield equipped.");
                break;
            case "ring":
                if(humanAcc[2]){
                    humanAcc[2] = false;
                    setMana(getMana()-getRing().getBoostMana());
                    System.out.println(getName() + " has unequipped the ring.");
                }else System.out.println(getName() + " doesn't have a ring equipped.");
                break;
            case "boots":
                if(humanAcc[3]){
                    humanAcc[3] = false;
                    setSpeed(getSpeed()-getBoots().getฺBoostSpeed());
                    System.out.println(getName() + " has unequipped the boots.");
                }else System.out.println(getName() + " doesn't have boots equipped.");
                break;
            default:
                System.out.println("Wrong input!");
        }
    }

    /**  upgrade accessory
     * @param a ชนิด accessory เป็น uppercase หรือ lowercase ก็ได้
     * effects: หากป้อนชนิด accessory ถูกต้องและเงินของตัวละครไม่น้อยกว่าราคาอัพเกรด
     *          - money จะลดลงตามราคาอัพเกรด
     *          - ค่าเฉพาะของ accessory จะเพิ่มขึ้น
     *          - stat ตัวละครจะเพิ่มขึ้นตาม accessory ที่ upgrade
     * effects: ข้อความที่บอกว่าการ upgrade accessory สำเร็จหรือไม่ ถูก print
     */
    @Override
    public void upgrade(String a) {
        switch(a.toLowerCase()){
            case "sword":
                if(getMoney() >= sword.getUpgradePrice()){
                    setMoney(getMoney()-sword.getUpgradePrice());
                    sword.upgrade();
                    setAtk(getAtk()+ sword.getSwordDmg());
                    System.out.println(getName() + "'s sword has been upgraded to Level " + sword.getLevel() + ".");
                }else System.out.println(getName() + " doesn't have enough money to upgrade the sword.");
                break;
            case "shield":
                if(getMoney() >= shield.getUpgradePrice()){
                    setMoney(getMoney()-shield.getUpgradePrice());
                    shield.upgrade();
                    setDef(getDef()+ shield.getShieldDef());
                    System.out.println(getName() + "'s shield has been upgraded to Level " + shield.getLevel() + ".");
                }else System.out.println(getName() + " doesn't have enough money to upgrade the shield.");
                break;
            case "ring":
                if(getMoney() >= getRing().getUpgradePrice()){
                    setMoney(getMoney()-getRing().getUpgradePrice());
                    getRing().upgrade();
                    setMana(getMana()+getRing().getBoostMana());
                    System.out.println(getName() + "'s ring has been upgraded to Level " + getRing().getLevel() + ".");
                }else System.out.println(getName() + " doesn't have enough money to upgrade the ring.");
                break;
            case "boots":
                if(getMoney() >= getBoots().getUpgradePrice()){
                    setMoney(getMoney()-getBoots().getUpgradePrice());
                    getBoots().upgrade();
                    setSpeed(getSpeed()+getBoots().getฺBoostSpeed());
                    System.out.println(getName() + "'s boots has been upgraded to Level " + getBoots().getLevel() + ".");
                }else System.out.println(getName() + " doesn't have enough money to upgrade the boots.");
                break;
            default:
                System.out.println("Wrong input!");
        }
    }

    /** ใช้ skill เฉพาะตัวของตัวละครประเภท Human : เพิ่มค่า def เป็น 2 เท่าชั่วขณะ
     * effects: หากค่า mana ของตัวละครมีค่าตั้งแต่ 30 เป็นต้นไป
     *          - ค่า mana, isStrengthAct, def ถูกเปลี่ยน
     *          - ข้อความที่แสดงว่าการใช้ skill สำเร็จถูก print
     */
    public void strength(){
        if(getMana() >= 30){
            setMana(getMana()-30);
            isStrengthAct = true;
            setDef(getDef()*2);
            System.out.println("Strength is activated.");
        }
    }

    /** ถูกโจมตี : เพิ่มกรณีที่ตัวละครใช้ skill จากที่ประกาศไว้ใน class Characters
     * @param oppAtk ค่า atk ของตัวละครฝ่ายตรงข้ามที่โจมตีมา
     * effects: ค่า hp ของตัวละครจะลดลงในกรณีที่ def น้อยกว่า oppAtk (inherited)
     * effects: หากตัวละครเลือกใช้ skill
     *          หลังจากที่ถูกโจมจตีแล้ว ค่า isStrengthAct, def จะกลับไปเป็นค่าเดิมก่อนที่จะใช้ skill
     */
    @Override
    public void beAttacked(double oppAtk) {
        super.beAttacked(oppAtk);
        if(isStrengthAct){
            isStrengthAct = false;
            setDef(getDef()/2);
        }
    }
}
