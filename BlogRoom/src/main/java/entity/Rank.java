package entity;

public class Rank {

    private Integer rankId;

    private Short rankLevel;

    private String rankName;

    public Integer getRankId() {
        return rankId;
    }

    public void setRankId(Integer rankId) {
        this.rankId = rankId;
    }

    public Short getRankLevel() {
        return rankLevel;
    }

    public void setRankLevel(Short rankLevel) {
        this.rankLevel = rankLevel;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    @Override
    public String toString() {
        return "Rank{" +
                "rankId=" + rankId +
                ", rankLevel=" + rankLevel +
                ", rankName='" + rankName + '\'' +
                '}';
    }
}