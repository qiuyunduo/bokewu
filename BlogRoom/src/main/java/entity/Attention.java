package entity;

public class Attention {

    private Integer aId;

    private Integer attentionId;

    private Integer attentionedId;

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public Integer getAttentionId() {
        return attentionId;
    }

    public void setAttentionId(Integer attentionId) {
        this.attentionId = attentionId;
    }

    public Integer getAttentionedId() {
        return attentionedId;
    }

    public void setAttentionedId(Integer attentionedId) {
        this.attentionedId = attentionedId;
    }

    @Override
    public String toString() {
        return "Attention{" +
                "aId=" + aId +
                ", attentionId=" + attentionId +
                ", attentionedId=" + attentionedId +
                '}';
    }
}