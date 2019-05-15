/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.max.customapplication.homePage;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;

public class BoundGoogleAPIClient {
    public static void bindGoogleAPIClientIn(LifecycleOwner lifecycleOwner,
                                             LocationListener listener,
                                             GoogleApiClient mGoogleApiClient,
                                             GoogleApiClient.ConnectionCallbacks googleApiConnectionCallbacks,
                                             GoogleApiClient.OnConnectionFailedListener googleApiConnectionFailedListener,
                                             Context context) {
        new GoogleAPIClient(lifecycleOwner, listener, mGoogleApiClient, googleApiConnectionCallbacks, googleApiConnectionFailedListener, context);
    }

    @SuppressWarnings("MissingPermission")
    static class GoogleAPIClient implements LifecycleObserver {
        private final Context mApplicationContent;
        private final LocationListener mLocationListener;
        private final GoogleApiClient.ConnectionCallbacks mGoogleApiConnectionCallbacks;
        private final GoogleApiClient.OnConnectionFailedListener mGoogleApiConnectionFailedListener;
        private GoogleApiClient mGoogleApiClient;
        private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;

        public GoogleAPIClient(LifecycleOwner lifecycleOwner, LocationListener listener,
                               GoogleApiClient mGoogleApiClient,
                               GoogleApiClient.ConnectionCallbacks googleApiConnectionCallbacks,
                               GoogleApiClient.OnConnectionFailedListener googleApiConnectionFailedListener,
                               Context mApplicationContent) {
            this.mApplicationContent = mApplicationContent;
            lifecycleOwner.getLifecycle().addObserver(this);
            this.mLocationListener = listener;
            this.mGoogleApiConnectionCallbacks = googleApiConnectionCallbacks;
            this.mGoogleApiConnectionFailedListener = googleApiConnectionFailedListener;
            this.mGoogleApiClient = mGoogleApiClient;
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        void createInstanceOfGoogleApiClient() {

        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        void connectApiClient() {
            if (mGoogleApiClient != null) {
                mGoogleApiClient.connect();
            }
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        void checkPlayServices() {


            // Note: Use the Fused Location Provider from Google Play Services instead.
            // https://developers.google.com/android/reference/com/google/android/gms/location/FusedLocationProviderApi

            /*mLocationManager =
                    (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);
            mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mListener);
            Log.d("BoundLocationMgr", "Listener added");

            // Force an update with the last location, if available.
            Location lastLocation = mLocationManager.getLastKnownLocation(
                    LocationManager.GPS_PROVIDER);
            if (lastLocation != null) {
                mListener.onLocationChanged(lastLocation);
            }*/
        }


        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        void removeLocationListener() {
           /* if (mLocationManager == null) {
                return;
            }
            mLocationManager.removeUpdates(mListener);
            mLocationManager = null;
            Log.d("BoundLocationMgr", "Listener removed");*/
        }
    }
}
