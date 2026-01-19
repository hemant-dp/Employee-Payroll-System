# Step 1: Base image badal kar v20 karein
FROM node:20-alpine AS build
WORKDIR /app

# Step 2: Dependencies install karein
COPY package*.json ./
RUN npm install

# Step 3: Source code copy aur build karein
COPY . .
RUN npx ng build --configuration production

# Stage 2: Nginx ke saath serve karein
FROM nginx:alpine
# Check karein ki dist/ ke baad folder ka naam 'frontend' hai ya kuch aur
COPY --from=build /app/dist/employee-payroll-frontend/browser /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]