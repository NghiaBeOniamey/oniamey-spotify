<template>
  <iframe
      title="Spotify Embed: Recommendation Playlist"
      :src="`https://open.spotify.com/embed/playlist/${playlistId}?utm_source=generator&theme=0`"
      width="100%"
      class="w-full h-[85vh]"
      frameBorder="0"
      allow="autoplay; clipboard-write; encrypted-media; fullscreen; picture-in-picture"
      loading="lazy"
  />
</template>

<script lang="ts">
export default {
  name: 'admin-listening-to-music',
};
</script>

<script lang="ts" setup>
const playlistId = '1pzKhr7Ve6dPTXTEcp0oi5';
const token = 'BQBmKwhdIRKMbYcvkGrG_PztAG_W96lOwq1Vdo2VupmqQpXlDLjnosR-96lJgxUje49t1iRL2u8BB-m3LuNegLwtQNJwgm3fR0JRTbreelmg3Tw4KswxtkHl8ylQzYJDdOBoTByHqr5zInx1NoRtP0KWkhPtsccFmfK3Rn9qNpywq1XWncaj6R1Foy4xVf8zCQYyW_esS2M4LsohVgax_miuwAAMjZk99ycTv_ZuNsmAzg8zj-wLUk030QxiTueAH4Bdla5jGih2iSNmfSpU3p7SZG8cWSTJ';

async function fetchWebApi(endpoint: string, method: string, body?: any) {
  const res = await fetch(`https://api.spotify.com/${endpoint}`, {
    headers: {
      Authorization: `Bearer ${token}`,
    },
    method,
    body: JSON.stringify(body),
  });
  return await res.json();
}

const tracksUri = [
  'spotify:track:2plbrEY59IikOBgBGLjaoe',
  'spotify:track:1i8dJGpKO0xQiKGCVslJqB',
  'spotify:track:0WbMK4wrZ1wFSty9F7FCgu',
  'spotify:track:6PGoSes0D9eUDeeAafB2As',
  'spotify:track:0xGQTpN4ESETtl1Sp6rzd2',
  'spotify:track:4nVBt6MZDDP6tRVdQTgxJg',
  'spotify:track:1Es7AUAhQvapIcoh3qMKDL',
  'spotify:track:0REms6Av7SrnzBEKXwxUoB',
  'spotify:track:1QoyuMHNBe7lg3YW4Qtll4',
  'spotify:track:3TPKsQTu9jZyzQJiax5rLA',
];

async function createPlaylist(tracksUri: string[]) {
  const {id: user_id} = await fetchWebApi('v1/me', 'GET');

  const playlist = await fetchWebApi(
      `v1/users/${user_id}/playlists`,
      'POST',
      {
        name: 'My recommendation playlist',
        description: 'Playlist created by the tutorial on developer.spotify.com',
        public: false,
      }
  );

  await fetchWebApi(
      `v1/playlists/${playlist.id}/tracks?uris=${tracksUri.join(',')}`,
      'POST'
  );

  return playlist;
}

createPlaylist(tracksUri);
</script>