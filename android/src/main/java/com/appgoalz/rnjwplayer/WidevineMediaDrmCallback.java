package com.appgoalz.rnjwplayer;

import android.text.TextUtils;

import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.longtailvideo.jwplayer.media.drm.MediaDrmCallback;

import java.io.IOException;
import java.util.UUID;

public class WidevineMediaDrmCallback implements MediaDrmCallback {

  private final String defaultUri;

  public WidevineMediaDrmCallback(String licenseUrl) {
    defaultUri = licenseUrl;
  }

  @Override
  public byte[] executeProvisionRequest(UUID uuid, ExoMediaDrm.ProvisionRequest request) throws IOException {
    String url = request.getDefaultUrl() + "&signedRequest=" + new String(request.getData());
    return Util.executePost(url, null, null);
  }

  @Override
  public byte[] executeKeyRequest(UUID uuid, ExoMediaDrm.KeyRequest request) throws IOException {
    String url = request.getLicenseServerUrl();
    if (TextUtils.isEmpty(url)) {
      url = defaultUri;
    }
    return Util.executePost(url, request.getData(), null);
  }

}
