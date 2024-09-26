package fyordo.lifeagragator.med.medicine.request;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicineFilter {
    @Nullable
    private String search = null;

    private List<Long> tagIds;

    private Boolean onlyMy = true;

    public MedicineFilter(Map<String, String> queryFilter){
        tagIds = new ArrayList<>();
        search = queryFilter.getOrDefault("search", null);
        onlyMy = Boolean.parseBoolean(queryFilter.get("onlyMy"));
    }
}
