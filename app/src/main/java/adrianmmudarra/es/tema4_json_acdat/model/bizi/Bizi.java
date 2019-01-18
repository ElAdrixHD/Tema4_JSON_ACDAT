package adrianmmudarra.es.tema4_json_acdat.model.bizi;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bizi {

    @SerializedName("totalCount")
    @Expose
    private Integer totalCount;
    @SerializedName("start")
    @Expose
    private Integer start;
    @SerializedName("rows")
    @Expose
    private Integer rows;
    @SerializedName("result")
    @Expose
    private List<Result> result = null;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }
}