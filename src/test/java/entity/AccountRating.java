package entity;

public enum AccountRating {

    NONE("--None--"),
    HOT("Hot"),
    WARM("Warm"),
    COLD("Cold");

    private String title;

    private AccountRating(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
