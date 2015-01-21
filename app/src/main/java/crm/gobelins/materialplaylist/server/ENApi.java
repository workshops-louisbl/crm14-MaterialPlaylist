package crm.gobelins.materialplaylist.server;

import android.content.Context;

import com.echonest.api.v4.EchoNestAPI;
import com.echonest.api.v4.EchoNestException;

import java.util.List;

import crm.gobelins.materialplaylist.R;

public class ENApi {
    private static ENApi sInstance;
    private EchoNestAPI mEchoNestApi;
    private List<String> mGenres;

    private ENApi(Context context) {
        mEchoNestApi = new EchoNestAPI(context.getString(R.string.echonest_api_key));
    }

    public static ENApi with(Context context) {
        if (null == sInstance) {
            sInstance = new ENApi(context);
        }
        return sInstance;
    }

    public void dumpStats() {
        mEchoNestApi.showStats();
    }

    public void syncAllGenres() throws EchoNestException {
        mGenres = mEchoNestApi.listGenres();
    }

    public List<String> getGenres() {
        return mGenres;
    }
}
