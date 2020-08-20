package haar.ter.tristan.interfaces;

import haar.ter.tristan.models.OV_Chipkaart;

import java.util.List;

public interface OV_ChipkaartDao
{
    List<OV_Chipkaart> findAll();

    List<OV_Chipkaart> findByReizigerID(long id);

    OV_Chipkaart findByID(long id);

    OV_Chipkaart save(OV_Chipkaart ov_chipkaart);

    OV_Chipkaart update(OV_Chipkaart ov_chipkaart);

    boolean delete(OV_Chipkaart ov_chipkaart);
}
