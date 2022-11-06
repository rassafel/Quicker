FROM node:18-slim
WORKDIR /opt/app/

ENV NODE_ENV=production \
    PORT=80

EXPOSE ${SERVER_PORT}

RUN addgroup --system --gid 1001 nodejs \
    && adduser --system --uid 1001 nextjs

COPY public ./public

COPY --chown=nextjs:nodejs .next/standalone ./
COPY --chown=nextjs:nodejs .next/static ./.next/static

USER nextjs

CMD ["node", "server.js"]
