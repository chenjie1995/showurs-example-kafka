package cn.showurs.example.kafka.consumer.dto;

import java.util.Date;

/**
 * Created by CJ on 2018/11/1 16:38.
 */
public class Work {
    private String content;
    private String creator;
    private String completer;
    private Date createTime;
    private Date completeTime;
    private Integer status;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCompleter() {
        return completer;
    }

    public void setCompleter(String completer) {
        this.completer = completer;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Work{" +
                "content='" + content + '\'' +
                ", creator='" + creator + '\'' +
                ", completer='" + completer + '\'' +
                ", createTime=" + createTime +
                ", completeTime=" + completeTime +
                ", status=" + status +
                '}';
    }
}
