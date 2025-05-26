import { defineConfig } from 'vite';
import { resolve } from 'path';
import { viteStaticCopy } from 'vite-plugin-static-copy';

export default defineConfig({

  build: {
    //outDir: 'dist', //soft/disk에 수정
    // === 경로 수정된 부분 ===
    outDir: resolve(__dirname, '../back/src/main/resources/static'),
    // =======================
    emptyOutDir: true, //백엔드의 static 폴더를 빌드 전에 비움
    cssCodeSplit: false,
    rollupOptions: {
      input: {
        index: resolve(__dirname, 'index.html'),
        login: resolve(__dirname, 'login.html'),
        join:  resolve(__dirname, 'join.html'),
        profile: resolve(__dirname, 'profile.html'),
        findmyid: resolve(__dirname, 'findmyid.html'),
        findmypw: resolve(__dirname, 'findmypw.html'),
        projectboard: resolve(__dirname, 'projectboard.html'),
        projectmanage: resolve(__dirname, 'projectmanage.html'),
        projectlist: resolve(__dirname, 'projectlist.html'),
        worklist: resolve(__dirname, 'worklist.html'),
        writework: resolve(__dirname, 'writework.html'),
        imageAssets: resolve(__dirname, 'src/images.js'),
      },
      output: {
        entryFileNames: '[name].[hash].js', 
        chunkFileNames: '[name].[hash].js',
        assetFileNames: (info) => {
          const ext = info.name?.split('.').pop();

          if (ext === 'png') {
            return 'assets/icon/[name].[hash].[ext]';
          }
          return 'assets/[name].[hash].[ext]';
        }

      }
    }
  },
});