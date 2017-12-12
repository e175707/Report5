package jp.ac.uryukyu.ie.e175707;

/**
 * ヒーロークラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Hero extends LivingThing {
    public Hero(String h_name,int h_hitpoint,int h_attack){
        super(h_name,h_hitpoint,h_attack);
    }
    @Override
    public void attack(LivingThing opponent) {
        if (getHitPoint() >= 0) {
            int prob =(int) (Math.random() * 10);
            int damage = (int) (Math.random() * getAttack());
            if (prob <= 3){
                damage = damage * 2;
                if(damage == 0){
                    System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n", getName(), opponent.getName());
                }else {
                    System.out.printf("%sの攻撃！会心の一撃！！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
                    opponent.wounded(damage);
                }
            }else{
                if(damage == 0){
                    System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n", getName(), opponent.getName());
                }else{
                    System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
                    opponent.wounded(damage);
                }
            }
        }
    }

    public void wounded(int damage){
        setHitPoint(getHitPoint() - damage);
        if( getHitPoint() < 0 ) {
            setDead(true);
            System.out.printf("%sは道半ばで力尽きてしまった。\n", getName());
        }
    }
}