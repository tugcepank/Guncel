package com.nexis.deneme;

public abstract class Rooms {
    private String roomName;
    private int harfSayisi;
    private String harfSabiti;

    // Constructor
    public Rooms(String roomName, int harfSayisi, String harfSabiti) {
        this.roomName = roomName;
        this.harfSayisi = harfSayisi;
        // Harf sabiti kontrolü yapılıyor
        if (harfSabiti.equals("V") || harfSabiti.equals("Y")) {
            this.harfSabiti = harfSabiti;
        } else {
            throw new IllegalArgumentException("Harf sabiti sadece 'V' veya 'Y' olabilir.");
        }
    }

    // Getter ve Setter metotları
    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getHarfSayisi() {
        return harfSayisi;
    }

    public void setHarfSayisi(int harfSayisi) {
        this.harfSayisi = harfSayisi;
    }

    public String getHarfSabiti() {
        return harfSabiti;
    }

    public void setHarfSabiti(String harfSabiti) {
        // Harf sabiti kontrolü yapılıyor
        if (harfSabiti.equals("V") || harfSabiti.equals("Y")) {
            this.harfSabiti = harfSabiti;
        } else {
            throw new IllegalArgumentException("Harf sabiti sadece 'V' veya 'Y' olabilir.");
        }
    }
}
