package com.survivalcoding.day04_calss_instance;

public class Slime {
    static final int MAX_HP = 20;
    static final int LEVEL = 10;
    
    private final String suffix;
    private int hp;
    
    Slime() {
        this("Z", MAX_HP);
    }
    
    Slime(String suffix) {
        this(suffix, MAX_HP);
    }
    
    Slime(String suffix, int hp) {
        Validator.validateNotNull(suffix);
        
        this.suffix = suffix;
        setHp(hp);
    }
    
    public int getHp() {
        return hp;
    }
    
    public void setHp(int hp) {
        this.hp = hp;
    }
    
    public String getSuffix() {
        return suffix;
    }
    
    void run() {
        System.out.printf("슬라임 %s가 도망갔다%n", suffix);
    }
}
