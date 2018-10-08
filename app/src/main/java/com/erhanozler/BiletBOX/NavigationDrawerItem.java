package com.erhanozler.BiletBOX;

import net.simplifiedcoding.bottomnavigationexample.R;

import java.util.ArrayList;


public class NavigationDrawerItem  {
    String baslik;
    int resimID;

    public String getBaslik() {
        return baslik;
    }

    public int getResimID() {
        return resimID;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public void setResimID(int resimID) {
        this.resimID = resimID;
    }

    public static ArrayList<NavigationDrawerItem> getData(){

        ArrayList<NavigationDrawerItem> dataList=new ArrayList<NavigationDrawerItem>();
        int[] resimIDs=getImages();
        String[] basliklar=getBasliklar();

        for(int i=0; i<basliklar.length; i++)
        {
            NavigationDrawerItem navItem=new NavigationDrawerItem();
            navItem.setBaslik(basliklar[i]);
            navItem.setResimID(resimIDs[i]);

            dataList.add(navItem);
        }

        return dataList;


    }

    private static int[] getImages() {
        return new int[]{
                R.drawable.ic_birds, R.drawable.kisiselbilgilerim,
                R.drawable.sepet, R.drawable.begendiklerim,
                 R.drawable.ayarlar};

    }

    private static String[] getBasliklar() {

        return new String[] {
                "Ana Sayfa", "Bilgilerim", "Sepetim", "Beğendiklerim",  "Ayarlar"
        };
    }
}
