package be.hcpl.android.so_2250770;

import java.util.Calendar;

/**
 * Only an example for a model object, we'll need something to show
 *
 * Created by hanscappelle on 7/10/14.
 */
public class ModelObject {

    private String title = null;

    private Calendar created = null;

    private boolean checked = false;

    public ModelObject(String title) {
        this.title = title;
        this.created = Calendar.getInstance();
        this.checked = false;
    }

    public ModelObject(String title, Calendar created, boolean checked) {
        this.title = title;
        this.created = created;
        this.checked = checked;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Calendar getCreated() {
        return created;
    }

    public void setCreated(Calendar created) {
        this.created = created;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
