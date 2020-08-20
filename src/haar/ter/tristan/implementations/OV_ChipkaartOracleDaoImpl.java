package haar.ter.tristan.implementations;

import haar.ter.tristan.interfaces.OV_ChipkaartDao;
import haar.ter.tristan.models.OV_Chipkaart;

import java.util.ArrayList;
import java.util.List;

public class OV_ChipkaartOracleDaoImpl implements OV_ChipkaartDao
{
    List<OV_Chipkaart> ov_chipkaarten = new ArrayList<>();

    @Override
    public List<OV_Chipkaart> findAll() {
        return this.ov_chipkaarten;
    }

    @Override
    public List<OV_Chipkaart> findByReizigerID(long id) {
        List<OV_Chipkaart> ov_chipkaartMetReizigerID = new ArrayList<>();
        for (OV_Chipkaart ov_chipkaart: this.ov_chipkaarten)
        {
            if(ov_chipkaart.getReizigerID() == id)
            {
                ov_chipkaartMetReizigerID.add(ov_chipkaart);
            }
        }
        return ov_chipkaartMetReizigerID;
    }

    @Override
    public OV_Chipkaart findByID(long id) {
        OV_Chipkaart foundOV_Chipkaart = null;
        for (OV_Chipkaart ov_chipkaart: this.ov_chipkaarten)
        {
            if(ov_chipkaart.getKaartNummer() == id)
            {
                foundOV_Chipkaart = ov_chipkaart;
            }
        }
        return foundOV_Chipkaart;
    }

    @Override
    public OV_Chipkaart save(OV_Chipkaart ov_chipkaart) {
        ov_chipkaarten.add(ov_chipkaart);
        return ov_chipkaart;
    }

    @Override
    public OV_Chipkaart update(OV_Chipkaart ov_chipkaart) {
        for (OV_Chipkaart opgeslagenOV_Chipkaart : this.ov_chipkaarten)
        {
            if(opgeslagenOV_Chipkaart.equals(ov_chipkaart))
            {
                opgeslagenOV_Chipkaart.setReizigerID(ov_chipkaart.getReizigerID());
                opgeslagenOV_Chipkaart.setKaartNummer(ov_chipkaart.getKaartNummer());
                opgeslagenOV_Chipkaart.setGeldigTot(ov_chipkaart.getGeldigTot());
                opgeslagenOV_Chipkaart.setKlasse(ov_chipkaart.getKlasse());
                opgeslagenOV_Chipkaart.setSaldo(ov_chipkaart.getSaldo());
                return opgeslagenOV_Chipkaart;
            }
        }
        return null;
    }

    @Override
    public boolean delete(OV_Chipkaart ov_chipkaart) {
        return this.ov_chipkaarten.remove(ov_chipkaart);
    }
}
