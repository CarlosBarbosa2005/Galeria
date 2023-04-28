package barbosa.souza.eduardo.carlos.galeria.model;

import android.net.Uri;

import androidx.lifecycle.ViewModel;

public class NewItemAcitivityViewModel extends ViewModel {

    Uri selectPhotoLocation = null;

    public Uri getSelectPhotoLocation(){
        return selectPhotoLocation;
    }

    public void setSelectPhotoLocation(Uri selectPhotoLocation){
        this.selectPhotoLocation = selectPhotoLocation;
    }
}
