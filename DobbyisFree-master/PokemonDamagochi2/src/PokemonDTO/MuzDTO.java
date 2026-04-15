package PokemonDTO;

import java.util.Random;

public class MuzDTO {
    int hp = 150;
    int attack;
    Random random = new Random();
   public MuzDTO() {
       this.hp = hp;
      
       // 20~50 사이 랜덤값으로 공격력 설정
       this.attack = random.nextInt(31) + 20;
   }

 

   public MuzDTO(PokemonDTO target) {
       target.HP -= this.attack;
   }

   public int getHp() {
       return hp;
   }

   public void setHp(int hp) {
       this.hp = hp;
   }

   public int getAttack() {
       return random.nextInt(31) + 20;
   }

   public void setAttack(int attack) {
       this.attack = attack;
   }
}