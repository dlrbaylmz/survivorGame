public class Obstacle {
    private int id;
    private String name;
    private int damage;
    private int health;
    private int award;
    private int orjHealth;

    public Obstacle(int id, String name, int damage, int health,int orjHealth, int award){
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.orjHealth = orjHealth;
        this.award = award;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0){
            health = 0;
        }
        this.health = health;
    }

    public int getOrjHealth() {
        return orjHealth;
    }

    public void setOrjHealth(int orjHealth) {
        this.orjHealth = orjHealth;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }
}
